package other;

public class GG {

	public static void main(String[] args) {
		new KK();
		new KK(100);
	}

}

class KK {
	final int g;
	
	public KK() {
		g = 10;
		System.out.println(g);
	}
	public KK(int id) {
		g = id;
		System.out.println(g);
	}
}
