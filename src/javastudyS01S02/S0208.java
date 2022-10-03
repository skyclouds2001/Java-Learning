package javastudyS01S02;
import java.util.Scanner;

public class S0208 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int amount = input.nextInt();
		double tax = amount * 0.06;
		System.out.println((int)(tax * 100 + 0.5) / 100.0 + "$");
		input.close();
		
	}

}
