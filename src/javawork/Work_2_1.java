package javawork;

// Work_2_1�� �̳� Base��

public class Work_2_1 extends Base {
	
	private int i = 2;
	
	public static void main(String[] args) {
		
		Work_2_1 no = new Work_2_1();
			// ����������һ��Work_2_1��
		no.increase();
			// Work_2_1��̳���Base���increase()������δ����д
			// ����Base���increase()����ʹBase��ĳ�Ա����i����
		System.out.println(no.i);
			// Base��ĳ�Ա����iΪprivateȨ�ޣ�Work_2_1���޷����ʣ���Work_2_1���ඨ���˳�Ա����i
			// ����no.i���õ���Work_2_1��ĳ�Ա����i
		System.out.println(no.getI());
			// Base���getI()����ΪpublicȨ�ޣ���δ����д��Work_2_1����Ե���
			// ����getI()�������õ���Base��ĳ�Ա����i

		no = new Work_2_1();
			// ���´���һ��Work_2_1��
			// ����no�Ƕ�һ���µ�Work_2_1�������
		no.increase();
		System.out.println(no.i);
		System.out.println(no.getI());
	}
}

class Base{
	
	private int i = 100;
	
	public void increase() {
		this.i++;
	}
	
	public int getI() {
		return (this.i);
	}
}
