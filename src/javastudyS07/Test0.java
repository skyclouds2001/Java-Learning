package javastudyS07;

public class Test0 {

	public static void main(String[] args) {
		
		double [] a1 = new double[10];
		double [] a2 = {1.2, 2.3, 3.4, 4.5, 5.6};
		System.out.printf("%d %d\n", a1.length, a2.length);
		
		for(double d: a2) {
			System.out.println(d);
		}
		
	}

}
