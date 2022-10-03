package javastudyS05;
import java.util.Scanner;

public class S0502_S0503 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = (int)(100 * Math.random());
		
		while(true) {
			System.out.print("Please input a number:");
			int guess = input.nextInt();
			
			if(guess == n) {
				System.out.println("You get it!");
				break;
			}
			else if(guess > n)
				System.out.println("You guess too high.");
			else
				System.out.println("You guess too low.");
		}
		
		input.close();
		
	}

}
