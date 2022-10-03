package javawork;

public class Work_1_4 {

	public static void main(String[] args) {
		
		int [] a = {1, 2, 3, 3, 8, 7, 6, 0, 9, 3, 4, 5, 12, 45, 56, 67, 78, 98, 43, 23, 56, 12, 21, 67, 90, 99, 56, 75, 23, 56, 32};
		int i = 0;
		
		//	依次输出数组中各个数
		for(int it: a) {
			System.out.println(i + " : " + it);
			++i;
		}
		
	}

}
