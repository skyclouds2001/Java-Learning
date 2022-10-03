package javastudyS09;

public class S0901 {

	public static void main(String[] args) {
		
		Circle c1 = new Circle();
		Circle c2 = new Circle(3.5);
		
		System.out.printf("R = %-10.2f L = %-10.2f S = %-10.2f\n", c1.getRadius(), c1.getPerimeter(), c1.getArea());
		System.out.printf("R = %-10.2f L = %-10.2f S = %-10.2f\n", c2.getRadius(), c2.getPerimeter(), c2.getArea());
		
	}

}

class Circle {
	private double radius;
	
	public Circle() {
		radius = 1;
	}
	
	public Circle(double newRadius) {
		radius = newRadius;
	}
	
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double newRadius) {
		this.radius = newRadius;
	}
	
}
