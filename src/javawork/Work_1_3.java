package javawork;

public class Work_1_3 {

	public static void main(String[] args) {
		
		int n = args.length;
		System.out.println("number : " + n);	//	输出命令提示符的数量
		
		for(int i = 0; i < n; ++i) {
			System.out.println(i + " : " + args[i]);
		}
		
	}

}
