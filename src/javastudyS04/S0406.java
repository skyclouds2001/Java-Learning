package javastudyS04;

public class S0406 {

	public static void main(String[] args) {
		
		int degree;
		double radine;
		System.out.printf("%10s%10s%10s%10s%10s\n", "Degrees", "Radians", "Sine", "Cosine", "Tangent");
		
		degree = 15;
		radine = Math.toRadians(degree);
		System.out.printf("%10d%10.4f%10.4f%10.4f%10.4f\n", degree, radine, Math.sin(radine), Math.cos(radine), Math.tan(radine));
		
		degree = 30;
		radine = Math.toRadians(degree);
		System.out.printf("%10d%10.4f%10.4f%10.4f%10.4f\n", degree, radine, Math.sin(radine), Math.cos(radine), Math.tan(radine));
		
		degree = 45;
		radine = Math.toRadians(degree);
		System.out.printf("%10d%10.4f%10.4f%10.4f%10.4f\n", degree, radine, Math.sin(radine), Math.cos(radine), Math.tan(radine));
		
		degree = 60;
		radine = Math.toRadians(degree);
		System.out.printf("%10d%10.4f%10.4f%10.4f%10.4f\n", degree, radine, Math.sin(radine), Math.cos(radine), Math.tan(radine));
		
		degree = 75;
		radine = Math.toRadians(degree);
		System.out.printf("%10d%10.4f%10.4f%10.4f%10.4f\n", degree, radine, Math.sin(radine), Math.cos(radine), Math.tan(radine));
		
	}

}
