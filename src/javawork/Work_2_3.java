package javawork;

public class Work_2_3 {
	public static void main(String args[]) {
		Base23 b = new Base23(100, 200);		// Base23构造函数原型为（Base23 (int x, int y)）有两个int类型参数 || 应添加参数
			// 构造函数只能在创建变量时调用，且只能调用一次 || 应去掉该行
		System.out.println(b.Base230());
	}
}

class Base23 {		// 不能加default，无权限修饰符即{default} || 去掉default
	private int x = 10;
	private int y = 20;
	Base23 (int x, int y) {
		this.x = x;
		this.y = y;
	}
	int Base230() {		// Base23()与构造函数和类名重名，是不被建议的，最好修改Base23类名 || 修改Base230()方法名
		return x + y;
	}
}

