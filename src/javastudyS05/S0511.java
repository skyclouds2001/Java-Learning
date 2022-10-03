package javastudyS05;
import java.util.Scanner;

public class S0511 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a number : ");
		int n = input.nextInt(), t = n;
		String hex = "";
		while(t > 0) {
			int k = t % 16;
			char hexDigit = (k >= 0 && k <= 9)?(char)(k + '0'):(char)(k - 10 + 'A');
			hex = hexDigit + hex;
			t /= 16;
		}
		input.close();
		System.out.println("The hex of the number is " + hex + ".");
	}

}
