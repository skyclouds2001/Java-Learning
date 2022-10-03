package javastudyS06;

import java.util.Scanner;

public class T0635 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the side : ");
		double side = input.nextDouble();
		input.close();
		
		System.out.printf("The area of the pentagon is %.5f", area(side));

	}

	public static double area(double side) {
		
		return (5.0 * side * side) / (4 * Math.tan(Math.PI / 5));
		
	}
}
