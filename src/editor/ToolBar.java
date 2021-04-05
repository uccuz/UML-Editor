package editor;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JToolBar;

public class ToolBar extends JToolBar{
	
	ToolBar() {
		
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(Color.red);
	}
}
