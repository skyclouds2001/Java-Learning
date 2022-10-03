package javastudyS03;
import java.util.Scanner;

public class S0306 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n % 2 == 0 && n % 3 == 0)
			System.out.println("2 and 3");
		if(n % 2 == 0 || n % 3 == 0)
			System.out.println("2 or 3");
		if(n % 2 == 0 ^ n % 3 == 0)
			System.out.println("2 xor 3");
		input.close();
		
	}

}
