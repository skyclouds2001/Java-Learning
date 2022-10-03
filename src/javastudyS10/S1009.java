package javastudyS10;
import java.math.*;

public class S1009 {

	public static void main(String[] args) {
		
		BigInteger b = BigInteger.ONE;
		
		for(int i = 1; i < 100; ++i) {
			b = b.multiply(new BigInteger(i + ""));
		}
		
		System.out.println("100! = " + b);
		
	}

}
