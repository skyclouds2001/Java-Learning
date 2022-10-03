package experiment04;

public class E0477 extends Base{
	private int i=2;
	public static void main(String[] args){
		E0477 no=new E0477();
		no.increase();
		System.out.println(no.i);
		System.out.println(no.getI());
	}
}
class Base{
	private int i=100;
	public void increase(){
		this.i++;
	}
	public int getI(){
		return this.i;
	}
}

