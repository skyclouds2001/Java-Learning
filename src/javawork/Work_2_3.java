package javawork;

public class Work_2_3 {
	public static void main(String args[]) {
		Base23 b = new Base23(100, 200);		// Base23���캯��ԭ��Ϊ��Base23 (int x, int y)��������int���Ͳ��� || Ӧ��Ӳ���
			// ���캯��ֻ���ڴ�������ʱ���ã���ֻ�ܵ���һ�� || Ӧȥ������
		System.out.println(b.Base230());
	}
}

class Base23 {		// ���ܼ�default����Ȩ�����η���{default} || ȥ��default
	private int x = 10;
	private int y = 20;
	Base23 (int x, int y) {
		this.x = x;
		this.y = y;
	}
	int Base230() {		// Base23()�빹�캯���������������ǲ�������ģ�����޸�Base23���� || �޸�Base230()������
		return x + y;
	}
}

