package editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


import java.util.ArrayList;

import modes.Mode;
import shapes.ClassObject;
import shapes.Shape;

public class DrawingArea extends JPanel {

	private Mode mode = null;
	
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	DrawingArea() {
		
		//this.setPreferredSize(new Dimension(100,100));
		//this.setBackground(Color.green);
		addShape(new ClassObject(100, 100));
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.setFont(new Font("Monaco",Font.PLAIN,16));
		
		// Draw all shapes in arrayList 
		shapes.forEach((shape)->{
			shape.draw(g2d);
		});
		
	}
}
