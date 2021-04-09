package modes;


import shapes.BasicObject;
import shapes.GroupObject;
import shapes.Line;

public class LineMode implements Mode {

	Line line = null;
	BasicObject frontObject = null;
	
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
			BasicObject endObject = canvas.selectObject(x, y);
			if(endObject == null || frontObject == endObject || endObject instanceof GroupObject) {
				canvas.removeShape(line);
			}
			else {
				line.setEndPort(endObject.getPort(x, y));
			}
		}
		line = null;
		frontObject = null;
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
		
		BasicObject frontObject = canvas.selectObject(x, y);
		if(frontObject == null)
			return null;
		if(frontObject instanceof GroupObject)
			return null;
		line.setFrontPort(frontObject.getPort(x, y));
		this.frontObject = frontObject;
		return line;
	}

}
