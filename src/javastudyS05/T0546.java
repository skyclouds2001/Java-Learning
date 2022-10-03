package javastudyS05; 
import java.util.Scanner;

public class T0546 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String s = input.nextLine();
		input.close();
		
		String ans = "";
		
		for(int i = 0; i < s.length(); ++i)
			ans = s.charAt(i) + ans;
		
		System.out.println("The reversed string is " + ans);
		
	}

}
