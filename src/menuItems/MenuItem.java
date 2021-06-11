package menuItems;

import javax.swing.JMenuItem;

import editor.Canvas;

public abstract class MenuItem extends JMenuItem {
	
	// Setting
	Canvas canvas = Canvas.getInstance();
	
	MenuItem(String name) {
		super(name);
	}
	
	public abstract void actionPerformed();
	
}
