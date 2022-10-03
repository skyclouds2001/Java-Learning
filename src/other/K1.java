package other;

public class K1 {

	public static void main(String[] args) {
		
		double sum = 0, a = 0;
		
		for(int i = 0, k = 1; i < 1e6; ++i) {
			a = (double)k / (2 * i + 1);
			sum += a;
			k *= -1;
		}
		sum *= 4;
		System.out.printf("\u03C0 \u2248 %.5f", sum);
		
	}

}
