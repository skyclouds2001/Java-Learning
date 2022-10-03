package javastudyS01S02;
import java.util.Scanner;

public class S0205 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for seconds.");
		int s = input.nextInt();
		int h = s / 3600;
		s %= 3600;
		int m = s / 60;
		s %= 60;
		System.out.println("The hours is " + h + ", minutes is " + m + ", seconds is " + s + '.');
		input.close();
		
	}

}
