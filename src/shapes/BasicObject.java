package shapes;

public abstract class BasicObject extends Shape{

	protected int width, height; 
	protected String name = "Object Name";
	
	public void setPosition(int x,int y) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + this.width;
		this.maxY = y + this.height;
	}
	
	public boolean isTouched(int x, int y) {
		//System.out.println("your X: " + x + " your Y: " + y);
		//System.out.println("minX: " + minX + " maxX: " + maxX + "minY: " + minY + " maxY: " + maxY);
		if(x > minX && x < maxX && y > minY && y < maxY) {
			return true;
		}
		return false;

	}
}
