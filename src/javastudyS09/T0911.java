package javastudyS09;
import java.util.Scanner;

public class T0911 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter a: ");
		double a = input.nextDouble();
		System.out.print("Please enter b: ");
		double b = input.nextDouble();
		System.out.print("Please enter c: ");
		double c = input.nextDouble();
		System.out.print("Please enter d: ");
		double d = input.nextDouble();
		System.out.print("Please enter e: ");
		double e = input.nextDouble();
		System.out.print("Please enter f: ");
		double f = input.nextDouble();
		
		LinearEquation le = new LinearEquation(a, b, c, d, e, f);
		
		if(le.isSolvable()) {
			System.out.println("The equation has two roots, x = " + le.getX() + " y = " + le.getY());
		}
		else {
			System.out.println("The equation has no solution.");
		}
		
		input.close();
	}

}

class LinearEquation {
	
	private double a = 0;
	private double b = 0;
	private double c = 0;
	private double d = 0;
	private double e = 0;
	private double f = 0;
	
	LinearEquation(double a, double b, double c, double d, double e, double f){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	
	public double getA() {
		return this.a;
	}
	public double getB() {
		return this.b;
	}
	public double getC() {
		return this.c;
	}
	public double getD() {
		return this.d;
	}
	public double getE() {
		return this.e;
	}
	public double getF() {
		return this.f;
	}
	
	public boolean isSolvable() {
		return (this.a * this.d - this.b * this.c != 0);
	}
	
	public double getX() {
		return (this.e * this.d - this.b * this.f) / (this.a * this.d - this.b * this.c);
	}
	
	public double getY() {
		return (this.a * this.f - this.e * this.c) / (this.a * this.d - this.b * this.c);
	}
}