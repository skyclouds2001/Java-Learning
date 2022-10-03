package experiment04;

class Meal { Meal() { System.out.println("Meal()"); } }

class Bread { Bread() { System.out.println("Bread()"); } }

class Cheese { Cheese() { System.out.println("Cheese()"); } }

class Lettuce { Lettuce() { System.out.println("Lettuce()"); } }

class Lunch extends Meal {
	Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
	PortableLunch() { System.out.println("PortableLunch()"); }
}

@SuppressWarnings("unused")
public class E0466 extends PortableLunch {

	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();
	public E0466() { System.out.println("Sandwich()"); }

	public static void main(String[] args) {
		new E0466();
	}
}

