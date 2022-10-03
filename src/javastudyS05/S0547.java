package javastudyS05;
import java.util.Scanner;

public class S0547 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first 12 digits of an ISBN-13 as a string : ");
		String s = input.nextLine();
		input.close();
		int [] d = new int[13];
		int sum = 0;
		s.trim();
		
		if(s.length() == 12) {
			for(int i = 0; i < 12; ++i) {
				d[i] = s.charAt(i) - '0';
				sum += d[i] * ((i % 2 == 0)? 3: 1);
			}
			
			d[12] = (10 - sum % 10) % 10;
			
			System.out.println("The ISBN-13 number is " + s + d[12]);
			
		}
		else
			System.out.println(s + " is an invalid input");
		
	}

}
