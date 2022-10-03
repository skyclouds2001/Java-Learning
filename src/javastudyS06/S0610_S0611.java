package javastudyS06;

class RandomCharacter{
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

public class S0610_S0611 {

	public static void main(String[] args) {
		
		final int NUMBER_OF_LINES = 250;
		final int CHARS_PER_LINES = 50;
		
		for(int i = 1; i <= NUMBER_OF_LINES; ++i) {
			
			int t = (int)(Math.random() * 4);
			char c = 0;
			
			switch(t) {
				case 0:
					c = RandomCharacter.getRandomLowerCaseLetter();
					break;
				case 1:
					c = RandomCharacter.getRandomUpperCaseLetter();
					break;
				case 2:
					c = RandomCharacter.getRandomDigit();
					break;
				case 3:
					c = RandomCharacter.getRandomCharacter();
					break;
			}
			
			System.out.print(c);
			
			if(i % CHARS_PER_LINES == 0) {
				System.out.println();
			}
			
		}
		
	}
}
