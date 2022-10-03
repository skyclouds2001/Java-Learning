package javastudyS09;
import java.util.Scanner;

public class T0910 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please input the a: ");
		double a = input.nextDouble();
		System.out.print("Please input the b: ");
		double b = input.nextDouble();
		System.out.print("Please input the c: ");
		double c = input.nextDouble();
		
		QuadraticEquation qe = new QuadraticEquation(a, b, c);
		
		if(qe.getDiscriminant() > 0) {
			System.out.println("Root1 is " + qe.getRoot1() + "Root2 is " + qe.getRoot2() + ".");
		}
		else if(qe.getDiscriminant() < 0) {
			System.out.println("The equation has no roots.");
		}
		else {
			System.out.println("The only root is " + qe.getRoot1());
		}
		
		input.close();
	}

}

class QuadraticEquation {
	
	public QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	private double a;
	private double b;
	private double c;
	
	public double geta() {
		return this.a;
	}
	public double getb() {
		return this.b;
	}
	public double getc() {
		return this.c;
	}
	
	public double getDiscriminant() {
		return this.b * this.b - 4 * this.a * this.c;
	}
	
	public double getRoot1() {
		
		if(this.getDiscriminant() >= 0) {
			return (- this.b + Math.sqrt(this.getDiscriminant())) / (2 * this.a);
		}
		else {
			return 0;
		}
	}
	
	public double getRoot2() {
		
		if(this.getDiscriminant() >= 0) {
			return (- this.b - Math.sqrt(this.getDiscriminant())) / (2 * this.a);
		}
		else {
			return 0;
		}
	}
	
}