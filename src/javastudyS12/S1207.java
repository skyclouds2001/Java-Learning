package javastudyS12;

public class S1207 {

	public static void main(String[] args) {
		
		try {
			new RegularPolygon(-1, 2);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		
	}

}

class RegularPolygon {
	 private int n = 3;
	 private double side = 1;
	 private double x = 0;
	 private double y = 0;
	 
	 RegularPolygon(){
	 }
	 RegularPolygon(int n, double side) throws IllegalArgumentException {
		 if(n >= 0 && side >= 0) {
			 this.n = n;
			 this.side = side;
		 }
		 else
			 throw new IllegalArgumentException("Negative input.");
	 }
	 RegularPolygon(int n, double side, double x, double y){
		 this(n, side);
		 this.x = x;
		 this.y = y;
	 }
	 
	 public int getN() {
		 return this.n;
	 }
	 public double getSide() {
		 return this.side;
	 }
	 public double getX() {
		 return this.x;
	 }
	 public double getY() {
		 return this.y;
	 }
	 
	 public void setN(int n) {
		 this.n = n;
	 }
	 public void setSide(double side) {
		 this.side = side;
	 }
	 public void setX(double x) {
		 this.x = x;
	 }
	 public void setY(double y) {
		 this.y = y;
	 }
	 
	 public double getPerimeter() {
		 return this.n * this.side;
	 }
	 
	 public double getArea() {
		 return this.n * this.side * this.side / 4 / Math.tan(Math.PI / this.n);
	 }
}
