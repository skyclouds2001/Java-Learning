package experiment04;

public class E0417 {
	
	float ptValue;
	
	public void changeObjValue(E0417 ref) {// �������Ͳ���
		ref.ptValue = 99.0f;  //�ı������ָ����ĳ�Ա����ֵ
	}
	
	public static void main(String args[]) {
		E0417 pt = new E0417();

		pt.ptValue = 101.0f;
		pt.changeObjValue(pt); // �������Ͳ����Ĵ���
		System.out.println("Pt value is: " + pt.ptValue);
	}

	
}

