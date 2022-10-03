package javastudyS05;
import java.util.Scanner;

public class S0514 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		System.out.print("Please input the word to judge : ");
		String judge = input.next();
		for(int i = 0, j = judge.length() - 1; i < j; ++i, --j) {
			if(judge.charAt(i) != judge.charAt(j)) {
				flag = false;
				break;
			}
		}
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");
		input.close();
		
	}

}
