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
import shapes.BasicObject;
import shapes.Shape;

public class Canvas extends JPanel{

	// Singleton object
	private static Canvas _Canvas = null;
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	Mode currentMode = null;
	
	Canvas() {
		this.addMouseListener(new ClickListener());		
		this.addMouseMotionListener(new DragListener());
	}
	
	// Static method to create instance of Singleton class
	public static Canvas getInstance() {
		if (_Canvas == null)
			_Canvas = new Canvas();
        return _Canvas;
	}
	
	// Add shape into drawing area
	public void addShape(Shape shape) {
		if(shape != null) {
			shapes.add(shape);
		}
	}
	
	// Get shape in canvas
	public Shape getShape(int i) {
		if( i >= 0 && i < shapes.size() )
			return shapes.get(i);
		return null;
	}
	
	// Remove shape in canvas
	public void removeShape(Shape shape) {
		if(shapes.contains(shape))
			shapes.remove(shape);
	}
	
	// Select shape in canvas
	public Shape selectShape(int x,int y) {
		int selected = -1;
		for(int i = 0 ; i < shapes.size() ; i++) {
			if(shapes.get(i).isTouched(x,y))
				selected = i;
		}
		if(selected != -1)
			return shapes.get(selected);
		return null;
	}
	
	// Select Object in canvas
	public ArrayList<BasicObject> getAllselectObject() {
		ArrayList<BasicObject> objects = new ArrayList<BasicObject>();
		shapes.forEach((shape)->{
			if(shape.isSelected && (shape instanceof BasicObject)) {
				objects.add((BasicObject)shape);
			}
		});
		return objects;
	}
	
	// Remove a list of object
	public void removeObjects(ArrayList<BasicObject> objects) {
		objects.forEach((object)->{
			removeShape(object);
		});
	}
	
	// Select all Object in canvas
	public BasicObject selectObject(int x,int y) {
		int selected = -1;
		for(int i = 0 ; i < shapes.size() ; i++) {
			if(shapes.get(i).isTouched(x,y) && (shapes.get(i) instanceof BasicObject))
				selected = i;
		}
		if(selected != -1)
			return (BasicObject)shapes.get(selected);
		return null;
	}
	
	// Clear all selection
	public void clearSelection() {
		shapes.forEach((shape)->{
			shape.isSelected = false;
		});
		this.repaint();
	}
	
	
	public void getSelection(int minX, int minY, int maxX, int maxY) {
		BasicObject basicObject;
		for(int i = 0 ; i < shapes.size() ; i++) {
			if((shapes.get(i) instanceof BasicObject)) {
				basicObject = (BasicObject)shapes.get(i);
				if(basicObject.isInside(minX, maxX, minY, maxY)) {
					basicObject.isSelected = true;
				}
			}
		}
	}
	
	
	// set drawing mode
	public void setMode(Mode mode) {
		currentMode = mode;
	}
	
	// Paint all thing
	public void paint(Graphics g) {
		
		super.paint(g);
		this.setBackground(new Color(35, 37, 37));
		
		
		// Draw setting
		g.setColor(Color.white);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(4));
		g2d.setFont(new Font("Monaco",Font.PLAIN,16));
		
		// Draw all shapes in arrayList 
		shapes.forEach((shape)->{
			shape.draw(g2d);
		});
		
	}

	// Handle all mouse event in canvas
	private class ClickListener extends MouseAdapter{
		
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
			if(currentMode == null)
				return;
			// Trigger mode
			currentMode.onMouseReleased(e.getX(), e.getY());
		}
	}
	
	// Handle all mouse motion event in canvas
	private class DragListener extends MouseMotionAdapter{
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if(currentMode == null)
				return;
			// Trigger mode
			currentMode.onMouseDragged(e.getX(), e.getY());
		}
	}


}
