package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	// Create menu
	JMenu fileMenu;
	JMenu editMenu;
	
	// Create menu item
	JMenuItem exitItem;
	JMenuItem groupItem;
	JMenuItem ungroupItem;
	JMenuItem changeObjectNameItem;
	
	MenuBar() {
		
		// Initialize menu
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		
		// Initialize menu item
		exitItem = new JMenuItem("Exit");
		groupItem = new JMenuItem("Group");
		ungroupItem = new JMenuItem("Ungroup");
		changeObjectNameItem = new JMenuItem("Change object name");
		
		// Create and add action listener
		MenuListener menuListener = new MenuListener();
		exitItem.addActionListener(menuListener);
		groupItem.addActionListener(menuListener);
		ungroupItem.addActionListener(menuListener);
		changeObjectNameItem.addActionListener(menuListener);
		
		// Add menu item into menu
		fileMenu.add(exitItem);
		editMenu.add(groupItem);
		editMenu.add(ungroupItem);
		editMenu.add(changeObjectNameItem);
		
		// Add menu into menuBar
		this.add(fileMenu);
		this.add(editMenu);
	}
	
	
	class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Handle all menu event
			if(e.getSource()==exitItem) {
				System.exit(0);	// Exit program
			}
			if(e.getSource()==groupItem) {
				System.out.println("groupItem");
			}
			if(e.getSource()==ungroupItem) {
				System.out.println("ungroupItem");
			}
			if(e.getSource()==changeObjectNameItem) {
				System.out.println("changeObjectNameItem");
			}
		}
		
	}
}
