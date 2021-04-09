package shapes;

import java.awt.Graphics;

public abstract class BasicObject extends Shape{
	
	protected int width, height; 
	protected String name = "Object Name";
	
	static final int PORTNUM = 4;
	static final int MARGIN = 10;
	
	protected Port ports[] = new Port[PORTNUM];
	
	BasicObject() {
		for(int i = 0 ; i < PORTNUM ; i++) {
			ports[i] = new Port(0,0);
		}
	}
	
	public void setPosition(int x,int y) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + this.width;
		this.maxY = y + this.height;
		setPortPosition();
	}
	
	protected void setPortPosition() {
		// Set port position
		ports[0].setPosition(minX + (maxX - minX)/2 -5, minY - MARGIN - 1);
		ports[1].setPosition(minX + (maxX - minX)/2 -5, maxY + MARGIN - 8);
		ports[2].setPosition(minX - MARGIN, minY + (maxY - minY)/2 - 5);
		ports[3].setPosition(maxX + MARGIN - 8, minY + (maxY - minY)/2 - 5);
	}
	
	protected void drawPort(Graphics g) {
		for(int i = 0 ; i < PORTNUM ; i++) {
			ports[i].draw(g);
		}
	}
	
	public boolean isTouched(int x, int y) {
		if(x > minX && x < maxX && y > minY && y < maxY) {
			return true;
		}
		return false;
	}
	
	public Port getPort(int x, int y) {
		
		// Find the shortest distance port
		int smaller = Integer.MAX_VALUE;
		int index = 0;
		for(int i = 0 ; i < ports.length ; i++ ) {
			if( smaller > ports[i].getDistance(x,y) ) {
				smaller = ports[i].getDistance(x,y);
				index = i;
			}
		}
		return ports[index];
	}
	
	public boolean isInside(int x1, int x2, int y1, int y2) {
		if( x1 < minX && minX < x2 && x1 < maxX && maxX < x2)
			if( y1 < minY && minY < y2 && y1 < maxY && maxY < y2)
				return true;
		return false;
	}
	

}
