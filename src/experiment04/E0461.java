package experiment04;

public class E0461{
	public static void main(String[] args){
		Rectangle rect=new Rectangle();
		rect.newDraw();
	}
}

class Shape{
	public void draw(){ System.out.println("Draw shape"); }
}

class Rectangle extends Shape{
	public void draw(){ System.out.println("Draw Rectangle"); }
	public void newDraw(){
		draw();
		super.draw();
	}
}

