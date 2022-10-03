package javawork;

public class Work_1_2 {
	
	public static void main(String[] args) {
		
		int x = (int) (Math.random() * 10) - 5;
		int y = 5;					//	y 未被初始化，后面直接赋值数组可能存在问题，应执行初始化
		
		if (x != 0)					//	x 不能直接做条件表达式，必须转为条件判断式
			y = 10;
		int [] a = new int[y];			//	应为 int [] a = new int[y]
		
		for (int i = 0; i < y; i++) {
			a[i] = i;
		}
		
		System.out.println(a[0]+a[y-1]);
	}

/*
public class GrammarDemo {
	public static void main(String[] args) {
		int x = (int) (Math.random() * 10) - 5;
		int y;
		
		if (x)			//x 不能直接做条件表达式，必须加入条件判断比较符号
			y = 10;
		int a[y];		//应为 int [] a = new int[y]; 且y 未被初始化，直接赋值数组可能存在问题，应执行初始化
		
		for (int i = 0; i < y; i++) {
			a[i] = i;
		}
		
    	System.out.println(a[0]+a[y-1]);
	}
}
*/

}
