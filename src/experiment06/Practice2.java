package experiment06;

public class Practice2 {

	public static void main(String[] args) {
		System.out.println(test(2));
	}
	
	public static int test(int code) {
		try {
			throw new IndexOutOfBoundsException("Test");
		} catch(Exception e) {
			System.out.println("catch: " + ("" + code));
			return code + 10;
		} finally {
			System.out.println("test: " + ("" + code));
			++code;
			System.out.println("test: " + ("" + code));
		}
	}

}
