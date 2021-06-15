package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GroupObject extends Shape {

	private ArrayList<Shape> shapes;
	
	static final int PORTNUM = 4;
	static final int MARGIN = 10;
	
	protected Port ports[] = new Port[PORTNUM];
	
	public GroupObject() {
		for(int i = 0 ; i < PORTNUM ; i++) {
			ports[i] = new Port(0,0);
		}
		setPortPosition();
	}
	
	protected void setPortPosition() {
		// Set port position
		ports[0].setPosition(minX + (maxX - minX)/2 -5, minY - 2*MARGIN - 1);
		ports[1].setPosition(minX + (maxX - minX)/2 -5, maxY + 2*MARGIN - 8);
		ports[2].setPosition(minX - 2*MARGIN, minY + (maxY - minY)/2 - 5);
		ports[3].setPosition(maxX + 2*MARGIN - 8, minY + (maxY - minY)/2 - 5);
	}
	
	protected void drawPort(Graphics g) {
		for(int i = 0 ; i < PORTNUM ; i++) {
			ports[i].draw(g);
		}
	}
	
	
	@Override
	public void addShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
		this.shapes.forEach((shape)->{
			shape.isSelected = false;
		});
		this.setNewPosition();
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		shapes.forEach((object)->{
			object.draw(g2d);
		});
		
		// Draw all ports
		if(isSelected)
			drawPort(g);
		
		g2d.setColor(new Color(128, 128, 128, 128));
		g2d.fillRect(minX - MARGIN, minY - MARGIN, maxX-minX + 2*MARGIN, maxY-minY + 2*MARGIN);
		g2d.setColor(Color.white);
	}

	@Override
	public void setPosition(int x, int y) {
		
		shapes.forEach((shape)->{
			shape.setPosition(shape.minX + (x - minX),shape.minY + (y - minY));
		});
		setNewPosition();
		setPortPosition();
		
	}

	@Override
	public boolean isTouched(int x, int y) {
		if(x > minX && x < maxX && y > minY && y < maxY) {
			return true;
		}
		return false;
	}

	public ArrayList<Shape> getObjects() {
		return shapes;
	}
	
	public void setNewPosition() {
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		for(int i = 0 ; i < shapes.size() ; i++ ) {
			minX = Math.min(minX,shapes.get(i).minX);
			minY = Math.min(minY,shapes.get(i).minY);
			maxX = Math.max(maxX,shapes.get(i).maxX);
			maxY = Math.max(maxY,shapes.get(i).maxY);
		}
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}
}
