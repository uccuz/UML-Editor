package modes;

import shapes.CompositionLine;

public class CompositionMode extends LineMode {
	
	@Override
	public void onMousePressed(int x, int y) {
		line = createLine(x, y, new CompositionLine(x, y));
		if(line != null) {
			canvas.addShape(line);
			canvas.repaint();
		}
	}
	
}