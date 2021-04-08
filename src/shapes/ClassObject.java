package shapes;

import java.awt.Graphics;

public class ClassObject extends BasicObject{

	static final int WIDTH = 120;
	static final int HEIGHT = 150; 
	
	public ClassObject(int x,int y) {
		super();
		// Set object size
		this.width = WIDTH;
		this.height = HEIGHT;
		// Set object position
		setPosition(x,y);
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
		
		// Draw all ports
		if(isSelected)
			drawPort(g);
		
	}



}
