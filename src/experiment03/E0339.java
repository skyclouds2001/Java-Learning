package experiment03;

public class E0339 {

	int x;
	public static void main(String[] args) {
		
		E0339 init = new E0339();
		int x = (int) (Math.random() * 100);
		int z;
		int y = 0; 			// int y=0;
		if (x > 50) {
			y = 9;
		}
		z = x + y + init.x;
		System.out.println("x = " + x + " y = " + y + 
					" z = " + z + " init.x = " + init.x);
		
	}

}
