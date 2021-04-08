package shapes;

import java.awt.Graphics;

public class CompositionLine extends Line{
	
	final int ARROWLENGTH = 5;
	
	public CompositionLine(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		setPosition();
		
		g.drawLine(minX,minY,maxX,maxY);
		drawArrow(g);

	}
	
	private void drawArrow(Graphics g) {
		
		int dx = maxX - minX;
		int dy = maxY - minY;
	
		double D = Math.sqrt(dx*dx + dy*dy);
		double sin = dy/D;
        double cos = dx/D;

        // Rotate matrix
        int leftX = (int)((D - ARROWLENGTH) * cos - ARROWLENGTH * sin + minX);
        int leftY = (int)((D - ARROWLENGTH) * sin + ARROWLENGTH * cos + minY);
        
        int rightX = (int)((D - ARROWLENGTH) * cos + ARROWLENGTH * sin + minX);
        int rightY = (int)((D - ARROWLENGTH) * sin - ARROWLENGTH * cos + minY);
        
        int backX = (int)(maxX - ARROWLENGTH*cos*2);
        int backY = (int)(maxY - ARROWLENGTH*sin*2);
		
        g.drawPolygon(new int[] {maxX, leftX, backX, rightX}, new int[] {maxY, leftY, backY, rightY}, 4);
        
	}
}

