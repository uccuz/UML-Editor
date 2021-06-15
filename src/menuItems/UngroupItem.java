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
		
		ArrayList<Shape> shapes;
		shapes = canvas.getAllSelectShape();
		if( shapes.size() != 1 ) {
			JOptionPane.showMessageDialog(canvas, "Please select only one group object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}
		/*
		if(!(objects.get(0) instanceof GroupObject)) {
			JOptionPane.showMessageDialog(canvas, "Please select only one group object!!","alert",JOptionPane.PLAIN_MESSAGE);
			return;
		}*/
		
		Shape shape = shapes.get(0);
		canvas.removeShape(shape);
		
		if(shape.getShapes() != null) {
			shape.getShapes().forEach((object)->{
				canvas.addShape(object);
			});
		}
		

		canvas.repaint();
	}
}
