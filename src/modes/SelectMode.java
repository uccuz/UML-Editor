package modes;


import shapes.Shape;

public class SelectMode implements Mode {

	Shape selectedShape = null;
	
	int prevX = 0;
	int prevY = 0;
	
	@Override
	public void onMousePressed(int x, int y) {
		// TODO Auto-generated method stub
		//System.out.println("start");
		if(selectedShape != null)
			selectedShape.isSelected = false;
		
		selectedShape = drawingArea.selectShape(x, y);
		
		if(selectedShape != null) {
			selectedShape.isSelected = true;
			drawingArea.repaint();
		}
		
		setPrevPos(x,y);
	}

	@Override
	public void onMouseReleased(int x, int y) {

	}

	@Override
	public void onMouseDragged(int x, int y) {
			
		if(selectedShape == null) {
			return;
		}
		/*System.out.println("x: " + x  + " y: " + y);*/
		int currentX = selectedShape.minX + ( x - prevX );
		int currentY = selectedShape.minY + ( y - prevY );
		selectedShape.setPosition(currentX, currentY);
		
		setPrevPos(x,y);

		drawingArea.repaint();
	}
	
	private void setPrevPos(int x,int y) {
		prevX = x;
		prevY = y;
	}
	
	/*private Shape selectShape(int x,int y) {
		Shape ArrayList<Shape> = drawingArea.GetShapeList();
		
		return null;
	}*/


}
