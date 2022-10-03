package experiment05;

class StaticInitDemo {
	static int i = 5;
	static {
		System.out.println("Static code: i=" + i++);
	}
}

public class TestStaticInit {
	public static void main(String args[]) {
		System.out.println("Main code: i=" + StaticInitDemo.i);
	}
}
