package modes;

import shapes.SelectObject;
import shapes.Shape;

public class SelectMode implements Mode {

	Shape selectedShape = null;
	Shape selectObject = null;
	
	private int prevX = 0;
	private int prevY = 0;
	
	@Override
	public void onMousePressed(int x, int y) {
		
		// Clear all shape select status
		canvas.clearSelection();
		// Select last shape which is touched in shapes
		selectedShape = canvas.selectShape(x, y);
		
		if(selectedShape != null) {
			selectedShape.setSelected(true);
		}
		else {
			selectObject = new SelectObject(x,y);
			canvas.addShape(selectObject);
		}
		
		canvas.repaint();
		setPrevPos(x,y);
	}

	@Override
	public void onMouseReleased(int x, int y) {
		
		// Remove selectObject in canvas
		if(selectObject != null) {
			canvas.removeShape(selectObject);
			selectObject = null;
		}
		
		canvas.repaint();
	}

	@Override
	public void onMouseDragged(int x, int y) {
		
		if(selectedShape != null) {
			selectedShape.setPosition(selectedShape.getMinX()+(x-prevX), selectedShape.getMinY()+(y-prevY));
		}
		else {
			if( selectObject != null )
				selectObject.setPosition(x, y);
			canvas.clearSelection();
			canvas.setSelection(selectObject.getMinX(),selectObject.getMinY(),selectObject.getMaxX(),selectObject.getMaxY());
		}
		setPrevPos(x,y);
		canvas.repaint();
	}
	
	private void setPrevPos(int x,int y) {
		prevX = x;
		prevY = y;
	}

}
