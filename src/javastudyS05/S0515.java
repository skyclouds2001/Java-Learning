package javastudyS05;

public class S0515 {

	public static void main(String[] args) {
		
		final int NUMBER_OF_PRIMES = 200;
		final int NUMBER_OF_PRIMES_PER_LINE = 10;
		int count = 2;
		int number = 0;
		
		System.out.println("The first 50 prime numbers are : ");
		
		while(count < NUMBER_OF_PRIMES) {
			boolean isprime = true;
			
			for(int k = 2 ; k <= Math.sqrt(count); ++k) {
				if(count % k == 0) {
					isprime = false;
					break;
				}
			}
			
			if(isprime) {
				++number;
				System.out.print(count + " ");
			}
			
			if(number == NUMBER_OF_PRIMES_PER_LINE) {
				number = 0;
				System.out.println();
			}
			
			++count;
			
		}
		
	}

}
