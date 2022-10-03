package other;

public class KH {

	public static void main(String[] args) {
		new Son();
	}

}

class Father {
	static {
		System.out.println("Father in static group");
	}
	public Father() {
		System.out.println("Father()");
	}
}

class Son extends Father {
	static {
		System.out.println("Son in static group");
	}
	public Son() {
		System.out.println("Son()");
	}
}
