package javastudyS12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class S1205 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		boolean flag = true;
		
		do {
			try {
				System.out.print("Enter a integer:");
				int num = input.nextInt();
				System.out.println("The integer input is:" + num);
				flag = false;
			}
			catch(InputMismatchException e) {
				System.out.println("Try again.(Incorrect input: an integer is required).");
				input.nextLine();
			}
		}while(flag);
		
		input.close();
	}

}
