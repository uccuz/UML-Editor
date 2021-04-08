package modes;


import shapes.SelectObject;
import shapes.Shape;

public class SelectMode implements Mode {

	Shape selectedShape = null;
	SelectObject selectObject = null;
	
	private int prevX = 0;
	private int prevY = 0;
	
	@Override
	public void onMousePressed(int x, int y) {
		canvas.clearSelection();
		selectedShape = canvas.selectShape(x, y);
		
		if(selectedShape != null) {
			selectedShape.isSelected = true;
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
		if(selectObject!= null) {
			canvas.removeShape(selectObject);
		}
		selectObject = null;
		
		canvas.repaint();
	}

	@Override
	public void onMouseDragged(int x, int y) {
		if(selectedShape != null) {
			selectedShape.setPosition(selectedShape.minX + ( x - prevX ), selectedShape.minY + ( y - prevY ));
		}
		else {
			selectObject.setPosition(x, y);
			canvas.clearSelection();
			canvas.getSelection(selectObject.getMinX(),selectObject.getMinY(),selectObject.getMaxX(),selectObject.getMaxY());
		}
		
		setPrevPos(x,y);
		canvas.repaint();
	}
	
	private void setPrevPos(int x,int y) {
		prevX = x;
		prevY = y;
	}

}
