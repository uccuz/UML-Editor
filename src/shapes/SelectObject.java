package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SelectObject extends Shape {

	public SelectObject(int x,int y) {
		minX = x;
		minY = y;
		setPosition(x,y);
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(new Color(128, 128, 128, 128));
		g2D.fillRect(getMinX(), getMinY() , Math.abs(maxX - minX),Math.abs(maxY - minY));
	}

	@Override
	public void setPosition(int x, int y) {
		maxX = x;
		maxY = y;
	}

	@Override
	public boolean isTouched(int x, int y) {
		return false;
	}
}
