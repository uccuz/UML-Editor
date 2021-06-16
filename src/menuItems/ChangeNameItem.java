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
		
		Shape shape = shapes.get(0);
		if(!shape.canChangeName()) {
			JOptionPane.showMessageDialog(canvas, "Please select only one basic object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}

        String name = JOptionPane.showInputDialog(canvas, "Please enter new name: ");
        if(name!= null)
        	shape.setName(name);
        
        canvas.repaint();
	}
}
