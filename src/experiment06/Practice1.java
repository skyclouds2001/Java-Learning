package experiment06;

public class Practice1 {
	public static void main(String[] args) {
		Practice1 p = new Practice1();
		try {
			System.out.println("try in main():");
			p.text();
		}
		catch(Exception e) {
			System.out.println("catch in main():");
			System.out.println(e);
		}
		finally {
			System.out.println("finally in main():");
		}
	}
	
	@SuppressWarnings("finally")
	private void text() throws IndexOutOfBoundsException{
		try {
			System.out.println("try in text():");
			throw new IndexOutOfBoundsException("text - try");
		}
		catch(Exception e) {
			System.out.println("catch in text():");
			System.out.println(e);
		}
		finally {
			System.out.println("finally in text():");
			throw new IndexOutOfBoundsException("text - catch");
		}
	}
}
