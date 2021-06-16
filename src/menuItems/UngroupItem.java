package menuItems;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import shapes.Shape;

public class UngroupItem extends MenuItem{

	public UngroupItem(String name) {
		super(name);
	}

	@Override
	public void actionPerformed() {
		
		ArrayList<Shape> shapes = canvas.getAllSelectShape();
		if( shapes.size() != 1 ) {
			JOptionPane.showMessageDialog(canvas, "Please select only one group object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}

		Shape shape = shapes.get(0);
		if(!shape.canUngroup()) {
			JOptionPane.showMessageDialog(canvas, "Please select only one group object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		canvas.removeShape(shape);
		
		if(shape.getShapes() != null) {
			shape.getShapes().forEach((object)->{
				canvas.addShape(object);
			});
		}

		canvas.repaint();
	}
}
