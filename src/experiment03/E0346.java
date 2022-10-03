package experiment03;

public class E0346 {

	public static void main(String[] args) {
		
		int a1 = 1, a2 = 1, a3 = 1, a4 = 1, a5 = 1;
		double d1 = 1.0, d2 = 1.0, d3 = 1.0;
		
		a1 = 46 / 9;
		System.out.println("a1 = " + a1);
		
		a2 = 46 % 9 + 4 * 4 - 2;
		System.out.println("a2 = " + a2);
		
		a3 = 45 + 43 % 5 * (23 * 3 % 2);
		System.out.println("a3 = " + a3);
		
		d1 = 4 + d1 * d1 + 4;
		System.out.println("d1 = " + d1);
		
		d2 += 1.5 * 3 + (++a4);
		System.out.println("d2 = " + d2);
		
		d3 -= 1.5 * 3 + a5++;
		System.out.println("d3 = " + d3);

		
	}

}
