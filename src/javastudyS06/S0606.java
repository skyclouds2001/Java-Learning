package javastudyS06;

import java.util.Scanner;

public class S0606 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first integer : ");
		int n1 = input.nextInt();
		System.out.print("Enter the first integer : ");
		int n2 = input.nextInt();
		
		System.out.println("The greatest common divisor for " + n1 + " and " + n2 + " is " + gcd(n1, n2) + ".");
		
		input.close();
		
	}
	
	public static int gcd(int a, int b) {
		
		if(a % b == 0)
			return b;
		else
			return gcd(b, a % b);
		
	}

}
