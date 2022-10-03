package javastudyS01S02;
import java.util.Scanner;

public class S0206 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int F = input.nextInt();
		double C = (5.0 / 9) * (F - 32);
		System.out.println(C);
		input.close();

	}

}
