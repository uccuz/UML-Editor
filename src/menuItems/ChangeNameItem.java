package menuItems;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import shapes.BasicObject;
import shapes.GroupObject;

public class ChangeNameItem extends MenuItem {

	public ChangeNameItem(String name) {
		super(name);
	}

	@Override
	public void actionPerformed() {
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

}
