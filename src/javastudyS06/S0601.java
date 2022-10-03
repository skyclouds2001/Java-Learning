package javastudyS06;
import java.util.Scanner;

public class S0601 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first number : ");
		int a = input.nextInt();
		System.out.print("Enter the second number : ");
		int b = input.nextInt();
		int ans = max(a, b);
		System.out.println("The maxium is " + ans);
		input.close();
		
	}
	
	public static int max(int x, int y)
	{
		return (x > y) ? x: y;
	}

}
