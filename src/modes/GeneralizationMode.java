package modes;

import shapes.GenerationLine;

public class GeneralizationMode extends LineMode {
	
	@Override
	public void onMousePressed(int x, int y) {
		line = createLine(x, y, new GenerationLine(x, y));
		if(line != null) {
			canvas.addShape(line);
			canvas.repaint();
		}
	}

}
