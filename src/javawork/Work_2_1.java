package javawork;

// Work_2_1类 继承 Base类

public class Work_2_1 extends Base {
	
	private int i = 2;
	
	public static void main(String[] args) {
		
		Work_2_1 no = new Work_2_1();
			// 声明并创建一个Work_2_1类
		no.increase();
			// Work_2_1类继承了Base类的increase()方法且未被重写
			// 所以Base类的increase()方法使Base类的成员变量i自增
		System.out.println(no.i);
			// Base类的成员变量i为private权限，Work_2_1类无法访问，且Work_2_1类亦定义了成员变量i
			// 所以no.i调用的是Work_2_1类的成员变量i
		System.out.println(no.getI());
			// Base类的getI()方法为public权限，且未被重写，Work_2_1类可以调用
			// 所以getI()方法调用的是Base类的成员变量i

		no = new Work_2_1();
			// 重新创建一个Work_2_1类
			// 现在no是对一个新的Work_2_1类的引用
		no.increase();
		System.out.println(no.i);
		System.out.println(no.getI());
	}
}

class Base{
	
	private int i = 100;
	
	public void increase() {
		this.i++;
	}
	
	public int getI() {
		return (this.i);
	}
}
