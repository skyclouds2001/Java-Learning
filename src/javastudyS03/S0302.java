package javastudyS03;
import java.util.Scanner;

public class S0302 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a number:");
		int n = input.nextInt();
		if(n % 2 == 0)
			System.out.println("HiEven");
		if(n % 5 == 0)
			System.out.println("HiFive");
		input.close();
		
	}

}
