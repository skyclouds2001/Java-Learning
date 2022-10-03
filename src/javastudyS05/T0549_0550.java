package javastudyS05;
import java.util.Scanner;

public class T0549_0550 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String s = input.nextLine();
		s = s.trim();
		input.close();
		
		int upperCase = 0, vowel = 0, consonant = 0;
		for(int i = 0; i < s.length(); ++i) {
			char t = s.charAt(i);
			if(Character.isUpperCase(t))
				++upperCase;
			t = Character.toLowerCase(t);
			if(t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u')
				++vowel;
			else
				++consonant;
		}
		System.out.println("The number of uppercase letters is " + upperCase);
		System.out.println("The number of vowels is " + vowel);
		System.out.println("The number of consonants is " + consonant);
		
	}

}
