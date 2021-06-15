package shapes;

import java.awt.Graphics;

public class Line extends Shape {
	
	Port frontPort = null;
	Port endPort = null;
	
	public Line(int x,int y) {
		setPosition(x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		setPosition();
		g.drawLine(minX,minY,maxX,maxY);
	}

	@Override
	public void setPosition(int x, int y) {
		this.minX = x;
		this.minY = y;
		this.maxX = x;
		this.maxY = y;
	}

	@Override
	public boolean isTouched(int x, int y) {
		return false;
	}
	
	public void setPosition() {
		if(frontPort != null) {
			minX = frontPort.minX + ( frontPort.maxX - frontPort.minX )/2;
			minY = frontPort.minY + ( frontPort.maxY - frontPort.minY )/2;
		}
		if(endPort != null) {
			maxX = endPort.minX + ( endPort.maxX - endPort.minX )/2;
			maxY = endPort.minY + ( endPort.maxY - endPort.minY )/2;
		}
	}
	
	public void setEndPosition(int x, int y) {
		this.maxX = x;
		this.maxY = y;
	}
	
	public void setFrontPort(Port port) {
		frontPort = port;
	}
	
	public void setEndPort(Port port) {
		endPort = port;
	}
	
	
}
