package javastudyS01S02;

public class S0207 {
	
	public static void main(String[] args) {
		
		long ms = System.currentTimeMillis();
		long s = ms / 1000;
		long min = (s / 60) % 60;
		long h = (s / 3600) % 24;
		s %= 60;
		System.out.println(h + " hours\n" + min + " minutes\n" + s + " seconds\n");
		
	}

}
