package modes;


import shapes.Shape;

public class SelectMode implements Mode {

	Shape selectedShape = null;
	
	private int prevX = 0;
	private int prevY = 0;
	
	@Override
	public void onMousePressed(int x, int y) {
		canvas.clearSelection();
		selectedShape = canvas.selectShape(x, y);
		
		if(selectedShape != null) {
			selectedShape.isSelected = true;
			canvas.repaint();
		}
		
		setPrevPos(x,y);
	}

	@Override
	public void onMouseReleased(int x, int y) {

	}

	@Override
	public void onMouseDragged(int x, int y) {
		if(selectedShape == null)
			return;
		
		selectedShape.setPosition(selectedShape.minX + ( x - prevX ), selectedShape.minY + ( y - prevY ));
		setPrevPos(x,y);
		canvas.repaint();
	}
	
	private void setPrevPos(int x,int y) {
		prevX = x;
		prevY = y;
	}

}
