package experiment04;

class Bird0 {
	
	int i;
//	public Bird0(int i) {
//		this.i=i;
//	}
}

public class T2 {
	public static void main(String[] args) {
		
		Bird0 nc = new Bird0(); // 缺省构造方法
		System.out.println(nc.i);
		nc.i = 10;
		System.out.println(nc.i);
		
	}
}

