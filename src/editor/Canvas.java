package editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import java.util.ArrayList;

import modes.Mode;
import shapes.Shape;

public class Canvas extends JPanel {

	// Singleton object
	private static Canvas _Canvas = null;
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	Mode currentMode = null;
	
	Canvas() {
		this.addMouseListener( new ClickListener() );		
		this.addMouseMotionListener( new DragListener() );
	}
	
	// Static method to create instance of Singleton class
	public static Canvas getInstance() {
		if ( _Canvas == null )
			_Canvas = new Canvas();
        return _Canvas;
	}

	// Add shape into shape list
	public void addShape(Shape shape) {
		if( shape != null )
			shapes.add(shape);
	}
	
	// Get shape in shape list
	public Shape getShape(int i) {
		if( i >= 0 && i < shapes.size() )
			return shapes.get(i);
		return null;
	}
	
	// Remove shape in shape list
	public void removeShape(Shape shape) {
		if(shapes.contains(shape))
			shapes.remove(shape);
	}
	
	// Select last shape which is touched in shapes
	public Shape selectShape(int x,int y) {
		int selected = -1;
		for( int i = 0 ; i < shapes.size() ; i++ ) {
			if(shapes.get(i).isTouched(x,y))
				selected = i;
		}
		if(selected != -1)
			return shapes.get(selected);
		return null;
	}
	
	// Select Shape in canvas
	public ArrayList<Shape> getAllSelectShape() {
		ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
		shapes.forEach((shape)-> {
			if(shape.getSelected())
				selectedShapes.add(shape);
		});
		return selectedShapes;
	}

	
	// Select shape which can be connected
	public Shape selectConnectShape(int x,int y) {
		int selected = -1;
		for(int i = 0 ; i < shapes.size() ; i++) {
			if(shapes.get(i).isTouched(x,y) && (shapes.get(i).canConnect()))
				selected = i;
		}
		if(selected != -1)
			return shapes.get(selected);
		return null;
	}
	
	// Clear all shape select status
	public void clearSelection() {
		shapes.forEach((shape)->{
			shape.setSelected(false);
		});
		this.repaint();
	}
	
	// Set shape isSelected status
	public void setSelection(int minX, int minY, int maxX, int maxY) {
		Shape shape;
		for(int i = 0 ; i < shapes.size() ; i++) {
			shape = shapes.get(i);
			if(shape.isInside(minX, maxX, minY, maxY)) {
				shape.setSelected(true);
			}
		}
	}
	
	// set drawing mode
	public void setMode(Mode mode) {
		
		this.clearSelection();
		currentMode = mode;
	}
	
	// Paint all thing
	public void paint(Graphics g) {
		
		// Draw canvas
		super.paint(g);
		this.setBackground(new Color(35, 37, 37));
		
		// Draw setting
		g.setColor(Color.white);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(4));
		g2d.setFont(new Font("Monaco",Font.PLAIN,16));
		

		// Draw all shapes in shape list 
		shapes.forEach((shape)->{
			shape.draw(g2d);
		});
	}

	// Handle all mouse event in canvas
	private class ClickListener extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(currentMode == null)
				return;
			// Trigger mode
			currentMode.onMousePressed(e.getX(), e.getY());
		}
		 
		@Override
		public void mouseReleased(MouseEvent e) {
			// GetCurentMode
			if( currentMode == null )
				return;
			// Trigger mode
			currentMode.onMouseReleased(e.getX(), e.getY());
		}
	}
	
	// Handle all mouse motion event in canvas
	private class DragListener extends MouseMotionAdapter {
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if( currentMode == null )
				return;
			// Trigger mode
			currentMode.onMouseDragged(e.getX(), e.getY());
		}
	}


}
