package experiment04;

public class E0415 {

	public void changeInt(int value) {// 基本类型的参数
		value = 55;
	}
	
	public static void main(String args[]) {
		
		int val;
		E0415 pt = new E0415();

		val = 11;
		pt.changeInt(val); // 基本类型参数的值传递
		System.out.println("Int value is: " + val);
	}

}

