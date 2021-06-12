package shapes;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Shape {
	
	public boolean isSelected = false;
	
	public int minX,minY;
	public int maxX,maxY;
	
	public abstract void draw(Graphics g);
	
	public abstract void setPosition(int x,int y);

	public abstract boolean isTouched(int x, int y);

	public void addShapes(ArrayList<Shape> shapes) {};
}
