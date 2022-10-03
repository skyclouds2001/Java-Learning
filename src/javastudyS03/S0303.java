package javastudyS03;
import java.util.Scanner;

public class S0303 {

	public static void main(String[] args) {
		
		int n1 = (int)(Math.random() * 10);
		int n2 = (int)(Math.random() * 10);
		
		if(n1 < n2) {
			int t = n1;
			n1 = n2;
			n2 = t;
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("What is the answer of " + n1 + '-' + n2 + '?');
		int ans = input.nextInt();
		
		if(ans == n1 - n2)
			System.out.println("Correct!");
		else {
			System.out.println("Wrong!");
			System.out.println(n1 + '-' + n2 + '=' + n1 - n2);
		}
		
		input.close();
		
	}

}
