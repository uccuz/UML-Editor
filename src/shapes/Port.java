package shapes;

import java.awt.Graphics;

public class Port extends Shape{

	static final int lENGTH = 10;
	static final int TOUCHSIZE = 5;
	
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
		// TODO Auto-generated method stub
		return false;
	}

}
