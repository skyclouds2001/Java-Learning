package experiment04;

class Glyph {
	void draw() { System.out.println("Glyph.draw()"); }
	Glyph() {
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}
}
class RoundGlyph extends Glyph {
	private int radius = 1;
	RoundGlyph(int r) {
		radius = r;
		System.out.println("RG.RoundGlyph(), radius = " + radius);
	}
	void draw() { System.out.println("RG.draw(), radius = " + radius); } 		//	方法重写在父类对象构造之前还是之后？

}
public class E0486 {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}

