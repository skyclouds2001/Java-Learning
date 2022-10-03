package javastudyS01S02;
import java.util.Scanner;

public class S0203 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double n1 = input.nextDouble();
		double n2 = input.nextDouble();
		double n3 = input.nextDouble();
		double aver = (n1 + n2 + n3)/3;
		System.out.println("The average is " + aver);
		input.close();
		
	}

}
