package javastudyS06;

class RandomCharacter0{
	public static char getRandomCharacter(char c1, char c2) {
		return (char)(c1 + Math.random()*(c2 - c1 + 1));
	}
	
	public static char getRandomLowerCaseLetter() {
		return getRandomCharacter('a', 'z');
	}
	
	public static char getRandomUpperCaseLetter() {
		return getRandomCharacter('A', 'Z');
	}
	
	public static char getRandomDigit() {
		return getRandomCharacter('0', '9');
	}
	
	public static char getRandomCharacter() {
		return getRandomCharacter('\u0000', '\uFFFF');
	}
}

public class T0638 {

	public static void main(String[] args) {
		
		final int NUMBER_OF_LINES = 100;
		final int CHARS_PER_LINES = 10;
		
		for(int i = 1; i <= NUMBER_OF_LINES; ++i) {
			
			char c = RandomCharacter0.getRandomUpperCaseLetter();
			
			System.out.print(c);
			
			if(i % CHARS_PER_LINES == 0) {
				System.out.println();
			}
			
		}
		
		System.out.println();
		
		for(int i = 1; i <= NUMBER_OF_LINES; ++i) {
			
			char c = RandomCharacter0.getRandomDigit();
			
			System.out.print(c);
			
			if(i % CHARS_PER_LINES == 0) {
				System.out.println();
			}
			
		}
		
	}
}
