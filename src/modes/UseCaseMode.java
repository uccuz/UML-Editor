package modes;

import shapes.UseCaseObject;

public class UseCaseMode implements Mode {

	@Override
	public void onMousePressed(int x, int y) {
		// TODO Auto-generated method stub
		Canvas.addShape(new UseCaseObject(x, y));
		Canvas.repaint();
	}

	@Override
	public void onMouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
