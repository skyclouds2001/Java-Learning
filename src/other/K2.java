package other;

import java.util.Scanner;

public class K2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("������һ��������");
		String n = input.nextLine();
		int sum = 0;
		
		if(n.charAt(0) == '-') {
			for(int i = 1; i < n.length(); ++i)
				sum += (n.charAt(i) - '0');
			sum *= -1;
		}
		else{
			for(int i = 0; i < n.length(); ++i)
				sum += (n.charAt(i) - '0');
		}
		
		System.out.println("������λ֮��Ϊ��" + sum);
		input.close();
		
	}

}
