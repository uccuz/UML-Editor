package editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import java.util.ArrayList;

import modes.Mode;
import modes.ModeManager;
import shapes.Shape;

public class DrawingArea extends JPanel{

	// singleton object
	private static DrawingArea _drawingArea = null;
	
	private ModeManager modeManager = new ModeManager();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	DrawingArea() {
		// Add mouse listener
		this.addMouseListener(new ClickListener());		
		this.addMouseMotionListener(new DragListener());

	}
	
	// Static method to create instance of Singleton class
	public static DrawingArea getInstance() {
		if (_drawingArea == null)
			_drawingArea = new DrawingArea();
  
        return _drawingArea;
	}
	
	// Add shape into drawing area
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	// Get shape in drawing area
	public Shape GetShape(int i) {
		if(i>=0 && i<shapes.size())
			return shapes.get(i);
		return null;
	}
	
	// Select shape in drawing area
	public Shape selectShape(int x,int y) {
		int selected = -1;
		for(int i = 0 ; i < shapes.size() ; i++) {
			if(shapes.get(i).isTouched(x,y)) {
				selected = i;
			}
		}
		if (selected != -1) {
			System.out.println("select: " + selected);
			return shapes.get(selected);
		}
		return null;
	}
	
	// Get shapeList in drawing area
	/*public ArrayList<Shape> GetShapeList() {
		return shapes;
	}*/
	
	
	// set drawing mode
	public void setMode(int i) {
		modeManager.setCurrentMode(i);
	}
	
	public void paint(Graphics g) {
		
		//¤£¥[·|Ãa±¼
		Dimension dim = getSize();
		g.setColor(new Color(35, 37, 37));
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.white);
		
		
		// Draw setting
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(4));
		g2d.setFont(new Font("Monaco",Font.PLAIN,16));
		
		// Draw all shapes in arrayList 
		shapes.forEach((shape)->{
			shape.draw(g2d);
		});
		
	}

	// Handle all mouse event in drawing area
	private class ClickListener extends MouseAdapter{
		
		public void mousePressed(MouseEvent e) {
			Mode mode = modeManager.GetCurrentMode();
			if(mode == null)
				return;
			mode.onMousePressed(e.getX(), e.getY());
		}
		public void mouseReleased(MouseEvent e) {
			Mode mode = modeManager.GetCurrentMode();
			if(mode == null)
				return;
			mode.onMouseReleased(e.getX(), e.getY());
		}
	}
	
	// Handle all mouse motion event in drawing area
	private class DragListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e) {
			Mode mode = modeManager.GetCurrentMode();
			if(mode == null)
				return;
			mode.onMouseDragged(e.getX(), e.getY());
		}
	}

}
