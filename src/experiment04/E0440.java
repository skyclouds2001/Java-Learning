package experiment04;

public class E0440{
	public static void main(String[] args){
		C obj=new C();	//Ĭ�Ϲ��췽����Ȩ������ķ���Ȩ����ͬ		obj.func2();
//		obj.func1();	//��C��ͬһ���е��������޷�����func1()
		obj.func2();
	}
}

class C{
	private void func1(){
		System.out.println("C's method 1");
	}
	void func2(){
		System.out.println("C's method 2");
		this.func1(); //ͬһ�����ڿ��Ե���func1()
	}
}
