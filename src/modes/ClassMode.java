package modes;

import shapes.ClassObject;

public class ClassMode implements Mode {

	@Override
	public void onMousePressed(int x, int y) {
		canvas.addShape(new ClassObject(x, y));
		canvas.repaint();
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
