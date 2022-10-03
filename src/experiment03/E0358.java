package experiment03;

public class E0358 {

	public static void main(String[] args) {
		
		//int x = 1, y = 1;
		
		//x > y > 0;
		//x = y && y;
		//x /= y;
		//x or y;
		//x and y;
		//(x != 0) || (x = 0);
		
		int a = 1, b = 1, c = 1;
		a = b += c = 5;
		System.out.printf("a = %d\nb = %d\nc = %d\n", a, b ,c);
		
	}

}
