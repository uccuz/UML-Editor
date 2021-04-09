package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;

public class GroupObject extends BasicObject{

	private ArrayList<BasicObject> objects;
	
	private final int MARGIN = 10;
	
	public GroupObject(ArrayList<BasicObject> objects) {
		this.objects = objects;
		objects.forEach((object)->{
			object.isSelected = false;
		});
		this.setNewPosition();
		setPortPosition();
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		objects.forEach((object)->{
			object.draw(g2d);
		});
		
		// Draw all ports
		if(isSelected)
			drawPort(g);
		
		g2d.setColor(new Color(128, 128, 128, 128));
		g2d.fillRect(minX - MARGIN, minY - MARGIN, maxX-minX + 2*MARGIN, maxY-minY + 2*MARGIN);
		
		g2d.setColor(Color.white);

	}

	@Override
	public void setPosition(int x, int y) {
		
		objects.forEach((object)->{
			object.setPosition(object.minX + (x - minX),object.minY + (y - minY));
		});
		setNewPosition();
		setPortPosition();
		
	}

	@Override
	public boolean isTouched(int x, int y) {
		if(x > minX && x < maxX && y > minY && y < maxY) {
			return true;
		}
		return false;
	}

	public ArrayList<BasicObject> getObjects() {
		return objects;
	}
	
	public void setNewPosition() {
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		for(int i = 0 ; i < objects.size() ; i++ ) {
			minX = Math.min(minX,objects.get(i).minX);
			minY = Math.min(minY,objects.get(i).minY);
			maxX = Math.max(maxX,objects.get(i).maxX);
			maxY = Math.max(maxY,objects.get(i).maxY);
		}
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}
	
	@Override
	protected void setPortPosition() {
		// Set port position
		ports[0].setPosition(minX + (maxX - minX)/2 -5, minY - 2*MARGIN - 1);
		ports[1].setPosition(minX + (maxX - minX)/2 -5, maxY + 2*MARGIN - 8);
		ports[2].setPosition(minX - 2*MARGIN, minY + (maxY - minY)/2 - 5);
		ports[3].setPosition(maxX + 2*MARGIN - 8, minY + (maxY - minY)/2 - 5);
	}

}
