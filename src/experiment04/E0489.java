package experiment04;

class Useful {
	public void f() { }
	public void g() { }
}
class MoreUseful extends Useful {
	public void f() { }
	public void g() { }
	public void u() { }
	public void v() { }
	public void w() { }
}
public class E0489 {
	public static void main(String[] args) {
		Useful[] x = { new Useful(), new MoreUseful() };
		x[0].f();
		x[1].g();
		// Compile time: method not found in Useful:
		// £¡ x[1].u();
		if (x[1] instanceof  MoreUseful)
			((MoreUseful) x[1]).u(); // Downcast/RTTI
		if (x[0] instanceof  MoreUseful)
			((MoreUseful) x[0]).u(); // Å×³öÒì³£
	}
}
