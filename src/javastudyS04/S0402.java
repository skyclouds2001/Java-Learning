package javastudyS04;
import java.util.Scanner;

public class S0402 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first city : ");
		String s1 = input.nextLine();
		System.out.print("Enter the second city : ");
		String s2 = input.nextLine();
		
		if(s1.compareTo(s2) > 0)
			System.out.println(s2 + " " + s1);
		else
			System.out.println(s1 + " " + s2);
		
		input.close();
	}

}
