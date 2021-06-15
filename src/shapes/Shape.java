package shapes;

import java.awt.Graphics;

import java.util.ArrayList;


public abstract class Shape {
	
	protected boolean isSelected = false;
	
	protected int minX,minY;
	protected int maxX,maxY;
	
	// Method need to override
	public abstract void draw(Graphics g);
	
	public abstract void setPosition(int x,int y);
	
	
	// Method create by parent
	public void setSelected(boolean status) {
		isSelected = status;
	}
	
	public boolean getSelected() {
		return isSelected;
	}
	
	public int getMinX() {
		return Math.min(minX, maxX);
	}
	
	public int getMinY() {
		return Math.min(minY, maxY);
	}
	
	public int getMaxX() {
		return Math.max(minX, maxX);
	}
	
	public int getMaxY() {
		return Math.max(minY, maxY);
	}
	
	// Composite pattern
	public boolean isTouched(int x, int y) { return false; };
	
	public boolean isInside(int x1, int x2, int y1, int y2) { return false; };
	
	public void addShapes(ArrayList<Shape> shapes) {};
	
	public ArrayList<Shape> getShapes() { return null; };
	
	public void setName(String name) {};
}
