package editor;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	MenuBar() {
		
		// Create menu
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		
		// Create menu item
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem groupItem = new JMenuItem("Group");
		JMenuItem ungroupItem = new JMenuItem("Ungroup");
		JMenuItem changeObjectNameItem = new JMenuItem("Change object name");
		
		// Add menu item into menu
		fileMenu.add(exitItem);
		editMenu.add(groupItem);
		editMenu.add(ungroupItem);
		editMenu.add(changeObjectNameItem);
		
		
		
		
		this.add(fileMenu);
		this.add(editMenu);
		
	}
}
