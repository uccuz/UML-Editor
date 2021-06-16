package menuItems;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import shapes.GroupObject;
import shapes.Shape;

public class GroupItem extends MenuItem {

	public GroupItem(String name) {
		super(name);
	}

	@Override
	public void actionPerformed() {
		
		ArrayList<Shape> shapes = canvas.getAllSelectShape();
		if(shapes.size() <= 1) {
			JOptionPane.showMessageDialog(canvas, "Please select at least two object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		// Add group object into canvas
		GroupObject groupObject = new GroupObject();
		groupObject.addShapes(shapes);
		canvas.addShape(groupObject);

		// Delete shapes in canvas
		shapes.forEach((shape)-> {
			canvas.removeShape(shape);
		});
		
		canvas.repaint();
	}
}
