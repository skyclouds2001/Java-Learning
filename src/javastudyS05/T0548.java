package javastudyS05;

import java.util.Scanner;

public class T0548 {

	public static void main(String[] args) {
		
		System.out.print("Enter a string : ");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		String ans = "";
		input.close();
		for(int i = 1; i < s.length(); i += 2)
			ans += s.charAt(i);
		System.out.println(ans);
		
	}

}
