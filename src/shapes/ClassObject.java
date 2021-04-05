package shapes;

import java.awt.BasicStroke;
import java.awt.Graphics;

public class ClassObject extends BasicObject{

	static final int WIDTH = 120;
	static final int HEIGHT = 150; 
	
	public ClassObject(int x,int y) {
		// Set object size
		this.width = WIDTH;
		this.height = HEIGHT;		
		// Set object position
		this.minX = x;
		this.minY = y;
		this.maxX = x + this.width;
		this.maxY = y + this.height;
	}
	@Override
	public void draw(Graphics g) {
		
		// Draw class object
		g.drawRect(minX, minY, width, height);
		g.drawLine(minX, minY + height/3 , maxX, minY + height/3);
		g.drawLine(minX, minY + (height*2)/3 , maxX, minY + (height*2)/3);
		
		// Draw class name
		int StringWidth = g.getFontMetrics(g.getFont()).stringWidth(name);
		g.drawString(name, minX+(Math.abs(minX-maxX) - StringWidth)/2 ,minY + (Math.abs(minY-maxY)/6));
		
		
	}

}
