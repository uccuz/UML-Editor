package shapes;

import java.awt.Graphics;

public abstract class BasicObject extends Shape{

	protected int width, height; 
	protected String name = "Object Name";
	
	static final int PORTNUM = 4;
	static final int MARGIN = 10;
	
	protected Shape port[] = new Port[PORTNUM];
	
	BasicObject() {
		for(int i = 0 ; i < PORTNUM ; i++) {
			port[i] = new Port(0,0);
		}
	}
	
	public void setPosition(int x,int y) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + this.width;
		this.maxY = y + this.height;
		setPortPosition();
	}
	
	private void setPortPosition() {
		// Set port position
		port[0].setPosition(minX + (maxX - minX)/2 -5, minY - MARGIN - 1);
		port[1].setPosition(minX + (maxX - minX)/2 -5, maxY + MARGIN - 8);
		port[2].setPosition(minX - MARGIN, minY + (maxY - minY)/2 - 5);
		port[3].setPosition(maxX + MARGIN - 8, minY + (maxY - minY)/2 - 5);
	}
	
	protected void drawPort(Graphics g) {
		for(int i = 0 ; i < PORTNUM ; i++) {
			port[i].draw(g);
		}
	}
	
	public boolean isTouched(int x, int y) {
		//System.out.println("your X: " + x + " your Y: " + y);
		//System.out.println("minX: " + minX + " maxX: " + maxX + "minY: " + minY + " maxY: " + maxY);
		if(x > minX && x < maxX && y > minY && y < maxY) {
			return true;
		}
		return false;

	}
}
