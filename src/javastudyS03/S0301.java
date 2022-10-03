package javastudyS03;
import java.util.Scanner;

public class S0301 {

	public static void main(String[] args) {
		
		int n1 = (int)System.currentTimeMillis()%10;
		int n2 = (int)System.currentTimeMillis()/10%10;
		Scanner input = new Scanner(System.in);
		System.out.println(n1 + " + " + n2 + " = ____");
		int ans = input.nextInt();
		if(ans == n1 + n2)
			System.out.println("Correct!");
		else
			System.out.println("Wrong!");
		input.close();
		
	}

}
