package editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import shapes.BasicObject;
import shapes.GroupObject;

public class MenuBar extends JMenuBar {

	// Create menu
	JMenu fileMenu;
	JMenu editMenu;
	
	// Create menu item
	JMenuItem exitItem;
	JMenuItem groupItem;
	JMenuItem ungroupItem;
	JMenuItem changeObjectNameItem;
	
	// Setting
	Canvas canvas = Canvas.getInstance();
	
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
	
	
	private void group() {
		ArrayList<BasicObject> objects;
		objects = canvas.getAllselectObject();
		if(objects.size() <= 1) {
			JOptionPane.showMessageDialog(canvas, "Please select at least one object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		canvas.removeObjects(objects);
		
		GroupObject groupObject = new GroupObject(objects);
		canvas.addShape(groupObject);
		canvas.repaint();
	}
	
	private void unGroup() {
		ArrayList<BasicObject> objects;
		objects = canvas.getAllselectObject();
		if(objects.size() != 1) {
			JOptionPane.showMessageDialog(canvas, "Please select only one group object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		if(!(objects.get(0) instanceof GroupObject)) {
			JOptionPane.showMessageDialog(canvas, "Please select only one group object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
			
		canvas.removeObjects(objects);
		
		GroupObject groupObject = (GroupObject)objects.get(0);
		groupObject.getObjects().forEach((object)->{
			canvas.addShape(object);
		});
		
		canvas.repaint();
	}
	
    private void changeObjectName() {
		ArrayList<BasicObject> objects;
		objects = canvas.getAllselectObject();
		if(objects.size() != 1) {
			JOptionPane.showMessageDialog(canvas, "Please select only one basic object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		if((objects.get(0) instanceof GroupObject) || !(objects.get(0) instanceof BasicObject)) {
			JOptionPane.showMessageDialog(canvas, "Please select only one basic object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
        String name = JOptionPane.showInputDialog(canvas, "Please enter new name: ");

        if( name!= null ) {
        	objects.get(0).name = name;
        }
        canvas.repaint();
    }
	
	class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Handle all menu event
			if(e.getSource()==exitItem) {
				System.exit(0);	// Exit program
			}
			if(e.getSource()==groupItem) {
				//System.out.println("groupItem");
				group();
			}
			if(e.getSource()==ungroupItem) {
				//System.out.println("ungroupItem");
				unGroup();
			}
			if(e.getSource()==changeObjectNameItem) {
				//System.out.println("changeObjectNameItem");
				changeObjectName();
			}
		}
		
	}
}
