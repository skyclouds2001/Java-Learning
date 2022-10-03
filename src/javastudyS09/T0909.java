package javastudyS09;

public class T0909 {

	public static void main(String[] args) {
		
		RegularPolygon rp1 = new RegularPolygon();
		RegularPolygon rp2 = new RegularPolygon(5, 2.2);
		RegularPolygon rp3 = new RegularPolygon(6, 3.3, 4.4, 5.5);
		
		System.out.printf("%f\t%f\t%f\n", rp1.getPerimeter(), rp2.getPerimeter(), rp3.getPerimeter());
		System.out.printf("%f\t%f\t%f\n", rp1.getArea(), rp2.getArea(), rp3.getArea());
	}

}

class RegularPolygon{
	
	 private int n = 3;
	 private double side = 1;
	 private double x = 0;
	 private double y = 0;
	 
	 RegularPolygon(){
	 }
	 RegularPolygon(int n, double side){
		 this.n = n;
		 this.side = side;
	 }
	 RegularPolygon(int n, double side, double x, double y){
		 this.n = n;
		 this.side = side;
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