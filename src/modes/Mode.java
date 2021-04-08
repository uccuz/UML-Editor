package modes;

import editor.Canvas;

public interface Mode {
	
	Canvas canvas = Canvas.getInstance();
	
	void onMousePressed(int x,int y);
	void onMouseReleased(int x,int y);
	void onMouseDragged(int x,int y);
}
