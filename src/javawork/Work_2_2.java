package javawork;

// Child�� �̳��� Work_2_2��
// ����main����
class Child extends Work_2_2 {
	public void func1() { System.out.println("Child func1 print."); }
	public void func2() { System.out.println("Child func2 print."); }
}

public class Work_2_2 {
	private void func1() {
		System.out.println("Base func1 print.");
	}
	
	public void func2() {
		System.out.println("Base func2 print.");
	}
	
	public static void main(String args[]) {
		Work_2_2 b = new Child();
			// ��Child��Ĺ��췽��������һ��Work_2_2�࣬b�Ƕ�Work_2_2�������
			// ��|����ת��|���������������еĲ��֣��������������඼�е����಻�ܱ�����̳еģ�
		b.func1();
			// Work_2_2���е�func1()����Ȩ��Ϊprivate��û�б�Child��̳У�Child���func1()�������Ƕ�Work_2_2���е�func1()��������д
			// b.func1()����Child���Work_2_2�෽��
		b.func2();
			// �෴�ģ�Work_2_2���е�func2()������Child��̳в���д
			// b.func2()����Child���func2()����
		((Child)b).func1();
		((Child)b).func2();
			// (Child)b��bǿ��ת��ΪChild��
			// ��|����ת��|
			// �ʵ��õ���Child���func1()������func2()����
	}
}
