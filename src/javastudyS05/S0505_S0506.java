package javastudyS05;
import java.util.Scanner;

public class S0505_S0506 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int sum = 0;
		int num = 0;
		do {
			System.out.print("Please input a number ( input 0 to end ) : ");
			num = input.nextInt();
			sum += num;
			
		}while(num != 0);
		System.out.println("The sum of numbers is " + sum + ".");
		
		input.close();
	}

}
