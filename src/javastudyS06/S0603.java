package javastudyS06;

public class S0603 {

public static void main(String[] args) {
		
		System.out.println("The grade is " + printGrade(98.5));
		System.out.println("The grade is " + printGrade(86.5));
		System.out.println("The grade is " + printGrade(78.5));
		System.out.println("The grade is " + printGrade(64.5));
		System.out.println("The grade is " + printGrade(59.5));
		
	}
	
	public static char printGrade(double score) {
		
		if(score >= 90)
			return 'A';
		else if(score >= 80)
			return 'B';
		else if(score >= 70)
			return 'C';
		else if(score >= 60)
			return 'D';
		else
			return 'E';
		
	}

	
}
