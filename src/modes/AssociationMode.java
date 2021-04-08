package modes;

import shapes.AssociationLine;

public class AssociationMode extends LineMode {
	
	@Override
	public void onMousePressed(int x, int y) {
		line = createLine(x, y, new AssociationLine(x, y));
		if(line != null) {
			canvas.addShape(line);
			canvas.repaint();
		}
	}
	
}
