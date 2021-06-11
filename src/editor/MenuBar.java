package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import menuItems.*;

public class MenuBar extends JMenuBar {

	// Create menu
	JMenu fileMenu;
	JMenu editMenu;
	
	// Setting
	MenuListener menuListener = new MenuListener();
	
		MenuBar() {
		
		// Initialize menu
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		
		// Initialize menu item
		this.addMenuItem(new ExitItem("Exit"), fileMenu);
		this.addMenuItem(new GroupItem("Group"), editMenu);
		this.addMenuItem(new UngroupItem("Ungroup"), editMenu);
		this.addMenuItem(new ChangeNameItem("Change object name"), editMenu);
		
		// Add menu into menuBar
		this.add(fileMenu);
		this.add(editMenu);
	}
	
	private void addMenuItem(MenuItem menuItem, JMenu menu) {
		menuItem.addActionListener(menuListener);
		menu.add(menuItem);
	}
	
	class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {	
			MenuItem menuItem = (MenuItem) e.getSource();	
			if( menuItem != null )
				menuItem.actionPerformed();
		}
	}
}
