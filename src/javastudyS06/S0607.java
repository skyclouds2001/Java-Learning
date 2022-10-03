package javastudyS06;

public class S0607 {

	public static void main(String[] args) {
		
		printPrime(50);
		
	}
	
	public static void printPrime(int numberOfPrimes) {
		
		final int NUMBER_OF_PRIMES_PER_LINE = 10;
		int count = 0;
		int number = 2;
		
		System.out.println("The first 50 prime numbers are : ");
		
		while(count < numberOfPrimes) {
			
			if(isprime(number)) {
				++count;
				System.out.printf("%-5d", number);
				
				if(count % NUMBER_OF_PRIMES_PER_LINE == 0)
					System.out.println();
			}
			
			++number;
			
		}
		
	}
	
	public static boolean isprime(int x) {
		
		for(int k = 2 ; k <= Math.sqrt(x); ++k) {
			if(x % k == 0) {
				return false;
			}
		}
		return true;
		
	}

}
