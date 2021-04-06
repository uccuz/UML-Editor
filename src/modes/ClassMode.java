package modes;

import shapes.ClassObject;

public class ClassMode implements Mode{

	@Override
	public void onMousePressed(int x, int y) {
		// TODO Auto-generated method stub
		drawingArea.addShape(new ClassObject(x, y));
		drawingArea.repaint();
	}

	@Override
	public void onMouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
