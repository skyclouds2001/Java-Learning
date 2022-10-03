package javastudyS05;
import java.util.Scanner;

public class T0545 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers : ");
		double [] a = new double[10];
		double sum = 0, ssum = 0;
		
		for(int i = 0; i < 10; ++i) {
			a[i] = input.nextDouble();
			sum += a[i];
			ssum += a[i] * a[i];
		}
		
		double aver = sum / 10.0;
		System.out.println("The mean is " + aver);
		
		double devia = Math.sqrt((ssum - sum * sum / 10.0) / 9.0);
		System.out.printf("The stardard deviation is %.4f", devia);
		
		input.close();
		
	}

}
