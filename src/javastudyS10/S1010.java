package javastudyS10;
import java.util.Scanner;

public class S1010 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		
		System.out.println(isPalindrome(s));
		
		input.close();
		
	}
	
	public static boolean isPalindrome(String s) {
		String s1 = reverse(s);
		String s2 = filter(s1);
		
		return (s2.equals(s1));
	}
	
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}
	
	public static String filter(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < sb.length(); ++i) {
			if(Character.isLetterOrDigit(sb.charAt(i)))
				sb.append(sb.charAt(i));
		}
		
		return sb.toString();
	}

}
