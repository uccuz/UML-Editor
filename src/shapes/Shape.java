package shapes;

import java.awt.Graphics;

public abstract class Shape {
	
	public int minX,minY;
	public int maxX,maxY;
	
	public abstract void draw(Graphics g);
}
