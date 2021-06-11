package menuItems;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import shapes.BasicObject;
import shapes.GroupObject;

public class UngroupItem extends MenuItem{

	public UngroupItem(String name) {
		super(name);
	}

	@Override
	public void actionPerformed() {
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

}
