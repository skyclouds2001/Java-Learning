package javastudyS04;
import java.util.Scanner;

public class T0417 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		System.out.print("Enter a month: ");
		String month = input.next();
		boolean isLegal = false;
		String monthName[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int monthDay[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int monthNumber = 0;
		
		if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
			monthDay[1] += 1;
		
		for(int i = 0; i < 12; ++i)
		{
			if(month.equals(monthName[i]))
			{
				isLegal = true;
				monthNumber = i;
			}
		}
		
		if(isLegal)
			System.out.println(month + ' ' + year + " has " + monthDay[monthNumber] + " days");
		else
			System.out.println(month + " is not a correct month name");
		
		input.close();
		
	}
}
