package javastudyS06;

import java.util.Scanner;

public class S0608 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a hex number : ");
		String hex = input.nextLine();
		System.out.println("The decimal value for hex number " + hex + " is " + hexToDeciamal(hex.toUpperCase()));
		
		input.close();
		
	}
	
	public static int hexToDeciamal(String hex) {
		
		int dec = 0;
		
		for(int i = 0; i < hex.length(); ++i) {
			
			dec *= 16;
			if(Character.isUpperCase(hex.charAt(i)))
				dec += (hex.charAt(i) - 'A' + 10);
			else if(Character.isLowerCase(hex.charAt(i)))
				dec += (hex.charAt(i) - 'a' + 10);
			else
				dec += (hex.charAt(i) - '0');
			
		}
		
		return dec;
	}

}
