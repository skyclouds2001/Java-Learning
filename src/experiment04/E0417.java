package experiment04;

public class E0417 {
	
	float ptValue;
	
	public void changeObjValue(E0417 ref) {// 引用类型参数
		ref.ptValue = 99.0f;  //改变参数所指对象的成员变量值
	}
	
	public static void main(String args[]) {
		E0417 pt = new E0417();

		pt.ptValue = 101.0f;
		pt.changeObjValue(pt); // 引用类型参数的传递
		System.out.println("Pt value is: " + pt.ptValue);
	}

	
}

