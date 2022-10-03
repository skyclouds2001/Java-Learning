package experiment03;

public class E0343 {

	public static void main(String[] args) {
		
		byte b=2;
		char c='\u1234';
		int x=8,y=3;
		//byte b2 = -b; //int值不能直接赋给byte类型变量b2
		//char c2 = +c; //int值不能直接赋给char类型变量c2
		System.out.println((-b) + ";" + (+c));
		int i=~b;	//byte转换为int
		System.out.println(Integer.toHexString(i));
		System.out.println(x/y);
		System.out.println(x/(float)y);

		
	}

}
