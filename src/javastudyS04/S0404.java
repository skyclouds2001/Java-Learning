package javastudyS04;
import java.util.Scanner;

public class S0404 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		
		if(s.length() == 1) {
			char c = Character.toUpperCase(s.charAt(0));
			if(c >= 'A' && c <= 'F')
				System.out.println("The decimal value for hex digit " + c + " is " + (c - 'A' + 10));
			else if(Character.isDigit(c))
				System.out.println("The decimal value for hex digit " + c + " is " + c);
			else
				System.out.println("Wrong input!");
		}
		else
			System.out.println("Wrong input!");
		input.close();
		
	}

}
