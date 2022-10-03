package experiment04;

public class E0416 {

	public void changeStr(String value) {  // 引用类型参数
		value = new String("different");  //方法中改变形参所指对象
	}
	
	public static void main(String args[]) {
		
		String str;
		E0416 pt = new E0416();

		str = new String("Hello");
		pt.changeStr(str); // 引用类型参数的传递
		System.out.println("Str value is: " + str);
	}

}

