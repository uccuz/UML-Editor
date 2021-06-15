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
		ArrayList<Shape> shapes;
		shapes = canvas.getAllSelectShape();
		if(shapes.size() <= 1) {
			JOptionPane.showMessageDialog(canvas, "Please select at least two object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		//canvas.removeObjects(objects);
		
		Shape groupObject = new GroupObject();
		groupObject.addShapes(shapes);
		canvas.addShape(groupObject);
		
		canvas.repaint();
	}
}
