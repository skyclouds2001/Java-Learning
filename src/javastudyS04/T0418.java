package javastudyS04;
import java.util.Scanner;

public class T0418 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two characters: ");
		String s = input.next();
		char major = s.charAt(0);
		int grade = s.charAt(1) - '0';
		input.close();
		
		if(major != 'M' && major != 'C' && major != 'I' && grade >= 1 && grade <= 4)
			System.out.println("Invalid input");
		else {
			switch(major)
			{
				case 'M':
					System.out.print("Mathematics ");
					break;
				case 'C':
					System.out.print("Computer Science ");
					break;
				case 'I':
					System.out.print("Information Technology ");
					break;
			}
			switch(grade)
			{
				case 1:
					System.out.println("Freshman");
					break;
				case 2:
					System.out.println("Sophomore");
					break;
				case 3:
					System.out.println("Junior");
					break;
				case 4:
					System.out.println("Senior");
					break;
			}
		} 
		
	}

}
