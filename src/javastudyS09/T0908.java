package javastudyS09;

public class T0908 {

	public static void main(String[] args) {
	
		Fan f1 = new Fan(), f2 = new Fan();
		
		f1.setSpeed(Fan.FAST);
		f1.setRadius(10);
		f1.setColor("yellow");
		f1.setOn(true);
		
		f2.setSpeed(Fan.MEDIUM);
		f2.setRadius(5);
		f2.setColor("blue");
		f2.setOn(false);
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
	}

}

class Fan {
	
	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;
	
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String color = "blue";
	
	public int getSpeed() {
		return this.speed;
	}
	public boolean isOn() {
		return this.on;
	}
	public double getRadius() {
		return this.radius;
	}
	public String getColor() {
		return this.color;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Fan() {
		
	}
	
	public String toString() {
		
		String s;
		if(this.isOn()) {
			s = this.speed + " | " + this.color + " | " + this.radius + "\n";
		}
		else {
			s = "fan is off | " + this.color + " | " + this.radius + "\n";
		}
		
		return s;
	}
	
}
