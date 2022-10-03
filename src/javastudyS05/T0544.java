package javastudyS05;

import java.util.Scanner;

public class T0544 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string : ");
		short n = input.nextShort();
		String ans = "";
		input.close();
		
		while(n != 0) {
			
			ans = (char)((n & 1) + '0') + ans;
			n >>= 1;
		}
		System.out.println("The bits are " + ans);
		
	}

}
