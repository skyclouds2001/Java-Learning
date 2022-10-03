package other;

public class P {

	public static void main(String[] args) {
		P1 p1 = new P1();
		P1 p2 = new P2();
//		P2 p3 = new P2();
		
//		System.out.println(p1.i);
//		System.out.println(p2.i);
//		System.out.println(p3.i);
		System.out.println(p1.j);
		System.out.println(p2.j);
		System.out.println(p1.k);
		System.out.println(p2.k);
//		System.out.println(p2.g);
	}

}

class P1 implements P3 {
	protected static final int i = 1;
	final int j = 13;
	int k = 23;
	public static final int g = 20;
}
class P2 extends P1 implements P3 {
	protected static final int i = 5;
	final int j = 15;
	int k = 25;
	public static final int g = 30;
}

interface P3 {
	public static final int g = 10;
}
