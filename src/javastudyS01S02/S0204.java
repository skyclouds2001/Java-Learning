package javastudyS01S02;
import java.util.Scanner;

public class S0204 {

	public static void main(String[] args) {
		
		final double PI = 3.1415926;
		Scanner input = new Scanner(System.in);
		double R = input.nextDouble(), S = R * R * PI;
		System.out.println("R = " + R + " " + "S = " + S);
		input.close();
		
	}

}
