package javastudyS05;
import java.util.Scanner;

public class S0501 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n1 = (int)(Math.random() * 1000);
		int n2 = (int)(Math.random() * 1000);
		System.out.println("What is the answer of " + n1 + "+" + n2 + "?");
		int ans = input.nextInt();
		while(n1 + n2 != ans)
		{
			System.out.println("Wrong answer!\nPlease input again!");
			ans = input.nextInt();
		}
		System.out.println("Correct!");
		input.close();
		
	}

}
