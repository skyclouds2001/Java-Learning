package experiment03;

public class E0324 {

	public static void main(String[] args) {
		
		//boolean f1 = -0.0 == 0.0;
		boolean f2 = 0.0 > -0.0;
		boolean f3 = 1.0 < Double.NaN;
		boolean f4 = 1.0 > Double.NaN;
		boolean f5 = 1.0 == Double.NaN;
		boolean f6 = 1.0 != Double.NaN;
		boolean f7 = Double. NaN == Double. NaN;
		double f8 = 0.0 / 0.0;
		double f9 = 1.0 / 0.0;
		double f10 = 1.0 / -0.0;
		
		//System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
		System.out.println("f3 = " + f3);
		System.out.println("f4 = " + f4);
		System.out.println("f5 = " + f5);
		System.out.println("f6 = " + f6);
		System.out.println("f7 = " + f7);
		System.out.println("f8 = " + f8);
		System.out.println("f9 = " + f9);
		System.out.println("f10 = " + f10);
		
	}

}
