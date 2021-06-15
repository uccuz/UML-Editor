package menuItems;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import shapes.Shape;

public class ChangeNameItem extends MenuItem {

	public ChangeNameItem(String name) {
		super(name);
	}

	@Override
	public void actionPerformed() {
		
		ArrayList<Shape> shapes = canvas.getAllSelectShape();
		if(shapes.size() != 1) {
			JOptionPane.showMessageDialog(canvas, "Please select only one basic object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		/*if(objects.get(0) instanceof GroupObject) || !(objects.get(0) instanceof BasicObject)) {
			JOptionPane.showMessageDialog(canvas, "Please select only one basic object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}*/
        String name = JOptionPane.showInputDialog(canvas, "Please enter new name: ");

        if(name!= null) {
        	shapes.get(0).setName(name);
        }
        canvas.repaint();
		
	}

}
