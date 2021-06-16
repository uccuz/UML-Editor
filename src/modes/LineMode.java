package modes;


import shapes.Shape;
import shapes.Line;

public class LineMode implements Mode {

	Line line = null;
	Shape frontShape = null;
	
	@Override
	public void onMousePressed(int x, int y) {
		line = createLine(x, y, new Line(x, y));
		if(line != null) {
			canvas.addShape(line);
			canvas.repaint();
		}
	}

	@Override
	public void onMouseReleased(int x, int y) {
		if(line != null) {
			Shape endShape = canvas.selectConnectShape(x, y);
			if(endShape == null || frontShape == endShape ) {
				canvas.removeShape(line);
			}
			else {
				line.setEndPort(endShape.getPort(x, y));
			}
		}
		line = null;
		frontShape = null;
		canvas.repaint();
	}

	@Override
	public void onMouseDragged(int x, int y) {
		if(line != null) {
			line.setEndPosition(x, y);
			canvas.repaint();
		}
	}
	
	public Line createLine(int x,int y,Line line) {
		
		Shape shape = canvas.selectConnectShape(x, y);
		if(shape == null)
			return null;
		
		line.setFrontPort(shape.getPort(x, y));
		this.frontShape = shape;
		
		return line;
	}

}
