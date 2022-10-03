package javastudyS01S02;
import java.util.Scanner;

public class S0202 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double r, s;
		r = input.nextDouble();
		s = r * r * 3.1414926;
		System.out.println("r = " + r + " " + "s = " + s);
		input.close();
		
	}

}
