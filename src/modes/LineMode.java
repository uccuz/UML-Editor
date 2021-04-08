package modes;


import shapes.BasicObject;
import shapes.Line;

public class LineMode implements Mode {

	Line line = null;
	//BasicObject frontObject = null;
	
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
			BasicObject object = canvas.selectObject(x, y);
			if(object == null) {
				canvas.removeShape(line);
			}
			else {
				line.setEndPort(object.getPort(x, y));
			}
		}
		line = null;
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
		
		BasicObject object = canvas.selectObject(x, y);
		if(object == null)
			return null;
		line.setFrontPort(object.getPort(x, y));
		return line;
	}

}
