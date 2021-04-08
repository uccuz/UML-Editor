package shapes;

import java.awt.Graphics;

public class Port extends Shape{

	static final int lENGTH = 10;
	static final int TOUCHSIZE = 10;
	
	public Port(int x,int y) {
		setPosition(x,y);
	}
	
	@Override
	public void draw(Graphics g) {
		g.fillRect(minX, minY, lENGTH, lENGTH);
	}

	@Override
	public void setPosition(int x, int y) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + lENGTH;
		this.maxY = y + lENGTH;
	}

	@Override
	public boolean isTouched(int x, int y) {
		if(x > (minX-TOUCHSIZE) && x < (maxX+TOUCHSIZE) && y > (minY-TOUCHSIZE) && y < (maxY + TOUCHSIZE)) {
			return true;
		}
		return false;
	}
	
	public int getDistance(int x2,int y2) {
		int x1 = minX + (maxX - minX)/2;
		int y1 = minY + (maxY - minY)/2;
		
		return (int)Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

}
