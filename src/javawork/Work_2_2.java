package javawork;

// Child类 继承了 Work_2_2类
// 包括main方法
class Child extends Work_2_2 {
	public void func1() { System.out.println("Child func1 print."); }
	public void func2() { System.out.println("Child func2 print."); }
}

public class Work_2_2 {
	private void func1() {
		System.out.println("Base func1 print.");
	}
	
	public void func2() {
		System.out.println("Base func2 print.");
	}
	
	public static void main(String args[]) {
		Work_2_2 b = new Child();
			// 用Child类的构造方法创建了一个Work_2_2类，b是对Work_2_2类的引用
			// 即|向上转型|，会隐藏子类特有的部分（包括父类与子类都有但父类不能被子类继承的）
		b.func1();
			// Work_2_2类中的func1()方法权限为private，没有被Child类继承，Child类的func1()方法不是对Work_2_2类中的func1()方法的重写
			// b.func1()调用Child类的Work_2_2类方法
		b.func2();
			// 相反的，Work_2_2类中的func2()方法被Child类继承并重写
			// b.func2()调用Child类的func2()方法
		((Child)b).func1();
		((Child)b).func2();
			// (Child)b将b强行转换为Child类
			// 即|向下转型|
			// 故调用的是Child类的func1()方法和func2()方法
	}
}
