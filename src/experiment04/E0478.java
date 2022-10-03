package experiment04;

public class E0478 {
	private void f() { System.out.println("private f()"); }
	public static void main(String[] args) {
		E0478 po = new Derived();
		po.f();
	}
}
class Derived extends E0478 {
	public int a;
	public void f() { System.out.println("public f()"); }
}
