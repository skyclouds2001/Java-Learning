package experiment04;

public class E0416 {

	public void changeStr(String value) {  // �������Ͳ���
		value = new String("different");  //�����иı��β���ָ����
	}
	
	public static void main(String args[]) {
		
		String str;
		E0416 pt = new E0416();

		str = new String("Hello");
		pt.changeStr(str); // �������Ͳ����Ĵ���
		System.out.println("Str value is: " + str);
	}

}

