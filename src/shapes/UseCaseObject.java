package shapes;

import java.awt.Graphics;

public class UseCaseObject extends BasicObject{

	static final int WIDTH = 120;
	static final int HEIGHT = 90; 
	
	public UseCaseObject(int x,int y) {
		super();
		// Set object size
		this.width = WIDTH;
		this.height = HEIGHT;		
		// Set object position
		setPosition(x,y);
	}
	
	@Override
	public void draw(Graphics g) {

		// Draw use case object
		g.drawOval(minX, minY, width, height);
		
		// Draw use case name
		int StringWidth = g.getFontMetrics(g.getFont()).stringWidth(name);
		g.drawString(name, minX+(Math.abs(minX-maxX) - StringWidth)/2 ,minY + (Math.abs(minY-maxY)/2));
		
		// Draw all ports
		if(isSelected)
			drawPort(g);
		
	}


}
