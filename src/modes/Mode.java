package modes;

import editor.DrawingArea;

public interface Mode {
	
	DrawingArea drawingArea = DrawingArea.getInstance();
	
	void onMousePressed(int x,int y);
	void onMouseReleased(int x,int y);
	void onMouseDragged(int x,int y);
}
