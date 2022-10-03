package javastudyS05;
import java.util.Scanner;

public class S0504 {

	public static void main(String[] args) {
		
		final int Number_Of_Questions = 3;
		Scanner input = new Scanner(System.in);
		long startTime = System.currentTimeMillis();
		int correctNumber = 0;
		String output = "";
		
		for(int i = 1; i <= Number_Of_Questions; ++i) {
			
			int n1 = (int)(Math.random() * 100);
			int n2 = (int)(Math.random() * 100);
			System.out.println("What is the answer of " + n1 + "+" + n2 + "?");
			int ans = input.nextInt();
			
			if(n1 + n2 == ans) {
				
				System.out.println("Correct!");
				++correctNumber;
				output += n1 + " + " + n2 + " = " + ans + " Correct" + "\n";
			}
			else {
				System.out.println("Wrong answer!");
				output += n1 + " + " + n2 + " = " + ans + " Wrong" + "\n";
			}
		}
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("The total time is " + totalTime / 1000 + " seconds.");
		System.out.println("The correct number of questions is " + correctNumber + " seconds.");
		System.out.println(output);
		
		input.close();
	}

}
