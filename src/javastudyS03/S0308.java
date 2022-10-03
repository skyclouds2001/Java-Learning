package javastudyS03;
import java.util.Scanner;

public class S0308 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int a = (int)(Math.random() * 100);
		int b = input.nextInt();
		
		if(a == b)
			System.out.println("10000$ !!!");
		else if(a / 10 == b % 10 && a % 10 == b / 10)
			System.out.println("3000$ !!");
		else if(a / 10 == b % 10 || a % 10 == b / 10 || a / 10 == b / 10 || a % 10 == b % 10)
			System.out.println("1000$ !!");
		else
			System.out.println("oh no");
		
		input.close();
		
	}

}
