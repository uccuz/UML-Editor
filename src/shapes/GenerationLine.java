package shapes;

import java.awt.Graphics;

public class GenerationLine extends Line{
	
	final int ARROWLENGTH = 7;
	
	public GenerationLine(int x, int y) {
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
		
        g.drawPolygon(new int[] {maxX, leftX, rightX}, new int[] {maxY, leftY, rightY}, 3);
        
	}
}

