package menuItems;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import shapes.BasicObject;
import shapes.GroupObject;

public class GroupItem extends MenuItem{

	public GroupItem(String name) {
		super(name);
	}

	@Override
	public void actionPerformed() {
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

}
