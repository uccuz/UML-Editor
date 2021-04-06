package editor;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import java.util.ArrayList;

import modes.Mode;
import shapes.Shape;
import shapes.ClassObject;
import shapes.UseCaseObject;

public class DrawingArea extends JPanel{

	// singleton object
	private static DrawingArea _drawingArea = null;
	
	private Mode mode = null;
	
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	DrawingArea() {
		
		// Add mouse listener
		this.addMouseListener(new ClickListener());
		
		addShape(new ClassObject(100, 100));
		addShape(new UseCaseObject(400, 100));
		

	}
	
	// Static method to create instance of Singleton class
	public static DrawingArea getInstance() {
		if (_drawingArea == null)
			_drawingArea = new DrawingArea();
  
        return _drawingArea;
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(4));
		g2d.setFont(new Font("Monaco",Font.PLAIN,16));
		
		// Draw all shapes in arrayList 
		shapes.forEach((shape)->{
			shape.draw(g2d);
		});
		
	}

	
	private class ClickListener extends MouseAdapter{
		
		// Handle mouse event
		public void mousePressed(MouseEvent e) {
			System.out.println("pressed");
			addShape(new ClassObject(e.getX(), e.getY()));
			//repaint();
		}
		public void mouseReleased(MouseEvent e) {
			System.out.println("release");
		}
	}
	

}
