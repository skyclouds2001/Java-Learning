package experiment04;

public class E0415 {

	public void changeInt(int value) {// �������͵Ĳ���
		value = 55;
	}
	
	public static void main(String args[]) {
		
		int val;
		E0415 pt = new E0415();

		val = 11;
		pt.changeInt(val); // �������Ͳ�����ֵ����
		System.out.println("Int value is: " + val);
	}

}

