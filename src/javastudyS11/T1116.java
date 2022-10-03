package javastudyS11;

import java.util.ArrayList;
import java.util.Scanner;

public class T1116 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n1 = (int)(Math.random() * 100);
		int n2 = (int)(Math.random() * 100);
		int ans = -1;
		ArrayList<Integer> list = new ArrayList<>();
		
		System.out.println("What is the answer of " + n1 + " + " + n2 + "?");
		do {
			ans = input.nextInt();
			
			if(n1 + n2 != ans) {
				if(list.indexOf(ans) == -1)
					System.out.println("Wrong answer! Try again!");
				else
					System.out.println("You already entered " + ans + "!");
				list.add(ans);
			}
			else {
				System.out.println("Correct!");
				break;
			}
		}while(true);
		
		input.close();
		
	}

}
