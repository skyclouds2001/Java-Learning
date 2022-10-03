package experiment04;
import java.util.Scanner;

public class E04main2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first Long Integer: ");
		String s1 = input.nextLine();
		System.out.print("Enter the second Long Integer: ");
		String s2 = input.nextLine();
		
		MyInteger i1 = new MyInteger(s1);
		MyInteger i2 = new MyInteger(s2);
		System.out.println("Integer1 Ϊ " + i1.getInteger());
		System.out.println("Integer1 �ĳ���Ϊ " + i1.arrayLength);
		System.out.println("Integer2 Ϊ " + i2.getInteger());
		System.out.println("Integer2 �ĳ���Ϊ " + i2.arrayLength);
		
		System.out.println("Integer1 �� Integer2 �ĺ�Ϊ " + (i1.add(i2)).getInteger());
		System.out.println("Integer1 �� Integer2 �Ĳ�Ϊ " + (i1.sub(i2)).getInteger());
		
		System.out.println("Integer1 �� Integer2 �ıȽ� " + i1.equals(i2));
		
		input.close();
	}

}

class MyInteger {
	
//	����ÿ�ε���󳤶ȣ�100�����쳤����ʱ�����ӳ�
//	����Ϊ��̬int���ͳ�Ա����
	protected final static int ARRAY_PER_LENGTH = 100;
	
//	������Сint�ͱ�����ֵ
	protected final static int MAX_INT_VALUE = 2147483647;
	protected final static int MIN_INT_VALUE = -2147483648;
	
//	�Դ洢�������������
	protected int [] arrayInt;
//	��������Ƿ���������    true����������false��������
	protected boolean isPositive;
	
//	�洢�������������ARRAY_PER_LENGTH������������
	protected int arrayCapacity;
//	�洢���ĳ��ȣ�������λ�������Ƹ��ţ�
	protected int arrayLength;
	
	
//	MyInteger�๹�캯����ͨ�����������ַ�������MyInteger�����
	public MyInteger(String strNum) {
		this.stringToThisArray(strNum);
	}
	
//	MyInteger�๹�캯����ͨ��MyNaturalNumbers����󴴽�MyInteger�����
	public MyInteger(MyNaturalNumbers num) {
		this.stringToThisArray(num.toString());
	}
	
//	���ش洢�����ڵ��������ַ�����ʽ����
//	����thisArrayToString()����
	public String getInteger() {
		return this.thisArrayToString();
	}
	
//	�����д洢�������ַ�����ʽ����
//	����stringToThisArray()����
	public void setInteger(String strNum){
		this.stringToThisArray(strNum);
	}
	
//	�Ƚ�����MyInteger������Ƿ����
//	��дObject���equals()����
//	����thisArrayToString()����
	public boolean equals(Object my) {
		return (this.thisArrayToString() == ((MyInteger)my).thisArrayToString());
	}
	
//	���ش洢���������ַ�����ʽ����
//	��дObject���toString()����
//	����thisArrayToString()����
	public String toString() {
		return this.thisArrayToString();
	}
	
//	�ӷ�������
	public MyInteger add(MyInteger my) {
		MyInteger ans = new MyInteger("");
		
	//  ������ͬ�����������ӣ����Ų���
		if(this.isPositive == my.isPositive) {
			
			ans = MyInteger.addBase(this, my);
			ans.isPositive = this.isPositive;
		}
	//  ���Ų�ͬ�����
		else {
			
		//  ���Ų�ͬ�����ǰΪ����
		//	��ǰ��С�ں������൱�ں�����ǰ����ȡ�෴�������Ϊ����
			if(this.isPositive && MyInteger.compare(this, my) == -1) {
				ans = MyInteger.subBase(my, this);
				ans.isPositive = false;
			}
		//  ��ǰ�����ڵ��ں�����������������Ϊ��
			else if(this.isPositive && MyInteger.compare(this, my) != -1) {
				ans = MyInteger.subBase(this, my);
				ans.isPositive = true;
			}
		//  ���Ų�ͬ����Һ�Ϊ����
		//  ���������ڵ���ǰ����������������Ϊ��
			else if(my.isPositive && MyInteger.compare(this, my) == -1) {
				ans = MyInteger.subBase(my, this);
				ans.isPositive = true;
			}
		//  ������С��ǰ�����൱��ǰ����������ȡ�෴�������Ϊ��
			else if(my.isPositive && MyInteger.compare(this, my) != -1) {
				ans = MyInteger.subBase(this, my);
				ans.isPositive = false;
			}
		}
		
		return ans;
	}
	
//	����������
	public MyInteger sub(MyInteger my) {
		MyInteger ans = new MyInteger("");
		
	//  ������ͬ���������Ϊ����
		if(this.isPositive && my.isPositive) {
		//  ��ǰ��С�ں������൱�ں�����ǰ����ȡ�෴�������Ϊ��
			if(MyInteger.compare(this, my) == -1) {
				ans = MyInteger.subBase(my, this);
				ans.isPositive = false;
			}
		//  ��ǰ�����ڵ��ں�����������������Ϊ��
			else {
				ans = MyInteger.subBase(this, my);
				ans.isPositive = true;
			}
		}
	//  ������ͬ���������Ϊ����
		else if(!this.isPositive && !my.isPositive) {
		//  ������С��ǰ�����൱��ǰ����������ȡ�෴�������Ϊ��
			if(MyInteger.compare(this, my) != -1) {
				ans = MyInteger.subBase(this, my);
				ans.isPositive = false;
			}
		//  ���������ڵ���ǰ����������������Ϊ��
			else {
				ans = MyInteger.subBase(my, this);
				ans.isPositive = true;
			}
		}
	//  ���Ų�ͬ���
		else {
			ans = MyInteger.addBase(this, my);
			
		//  ���Ų�ͬ�����ǰ��Ϊ����������ӣ����Ϊ��
			if(this.isPositive)
				ans.isPositive = true;
		//  ���Ų�ͬ�����ǰ��Ϊ����������ӣ����Ϊ��
			else
				ans.isPositive = false;
		}
		
		return ans;
	}
 	
//	�����ӷ������������Ƿ���
//  �����ӣ�����ָ��������ָ��
	static protected MyInteger addBase(MyInteger m1, MyInteger m2) {
		
		MyInteger ans = new MyInteger("");
		int maxlen = m2.arrayLength > m1.arrayLength ? m2.arrayLength : m1.arrayLength;
		ans.arrayCapacity = (maxlen / ARRAY_PER_LENGTH + 2) * ARRAY_PER_LENGTH;
		ans.arrayInt = new int[m1.arrayCapacity];
		
	//  ��λ��ӣ����ǽ�λ
		int i = 0;
		for(; i <= maxlen; ++i) {
			(ans.arrayInt)[i] += (m2.arrayInt)[i] + (m1.arrayInt)[i];
			(ans.arrayInt)[i + 1] += (ans.arrayInt)[i] / 10;
			(ans.arrayInt)[i] %= 10;
		}
		
	//  ������Ӻ��������� 
		if((ans.arrayInt)[i] != 0)
			ans.arrayLength = i;
		else
			ans.arrayLength = i - 1;
		
		return ans;
	}
	
//	�������������������Ƿ���
//	Ĭ��:m1�е�������ֵ����m2�е�������ֵ
//  �����ӣ�����ָ��������ָ��
	static protected MyInteger subBase(MyInteger m1, MyInteger m2) {
		
		MyInteger ans = new MyInteger("");
		int maxlen = m1.arrayLength >= m2.arrayLength ? m1.arrayLength : m2.arrayLength;
		ans.arrayCapacity = (maxlen / ARRAY_PER_LENGTH + 2) * ARRAY_PER_LENGTH;
		ans.arrayInt = new int[ans.arrayCapacity];
		
	//  ��λ�����������λ
		int i = 0;
		for(; i < maxlen; ++i) {
			if((m1.arrayInt)[i] >= (m2.arrayInt)[i]) {
				(ans.arrayInt)[i] = (m1.arrayInt)[i] - (m2.arrayInt)[i];
			}
			else {
				int k = i + 1;
				
				(m1.arrayInt)[i] += 10;
				while((m1.arrayInt)[k] == 0) {
					
					(m1.arrayInt)[k] += 9;
					++k;
				}
				--(m1.arrayInt)[k];
				
				(ans.arrayInt)[i] = (m1.arrayInt)[i] - (m2.arrayInt)[i];
			}
		}
		
	//  �����������������
		while((ans.arrayInt)[i] == 0 && i > 0)
			--i;
		ans.arrayLength = i + 1;
		
		return ans;
	}
	
//  �Ƚ��������������ֵ��С����
//  ����1����n1>n2,����0����n1=n2,����-1����n1<n2
	static protected int compare(MyInteger n1, MyInteger n2) {
		
	//  �ȱȽϳ��ȴ�С 
		if(n1.arrayLength > n2.arrayLength)
			return 1;
		else if(n1.arrayLength < n2.arrayLength)
			return -1;
	//  ��ͬ���ȴ�С����λ�Ƚ� 
		else {
			
			for(int i = n1.arrayLength - 1; i >= 0; --i) {
				
				if((n1.arrayInt)[i] > (n2.arrayInt)[i]) {
					return 1;
				}
				else if((n1.arrayInt)[i] < (n2.arrayInt)[i]) {
					return -1;
				}
			}
			
		// ��ȫ��ͬ����0
			return 0;
		}
	}
	
//	���������������ڴ洢����תΪ�ַ������
	protected String thisArrayToString() {
		String strNum = new String();
		
	//	���ΰ���������ȡ����ת���ַ���
		for(int i = 0; i < this.arrayLength; ++i)
			strNum = String.valueOf(this.arrayInt[i]) + strNum;
		
	//	���и������
		if(!this.isPositive)
			strNum = "-" + strNum;
		
		return strNum.strip();
	}

//	�������������ַ����洢������
	protected void stringToThisArray(String strNum) {
		
	//	���㲢��¼Ӧ���¿������������
	//	��֤��������λ�������㹻�Ķ�������
		int num = (strNum.length() / ARRAY_PER_LENGTH + 2) * ARRAY_PER_LENGTH;
		this.arrayInt = new int[num];
		this.arrayCapacity = num;
	//	����ǧ�ֺ����
		for(int p = strNum.indexOf(','); p != -1; p = strNum.indexOf(',')) {
			strNum = strNum.substring(0, p) + strNum.substring(p + 1, strNum.length());
		}
		
		int head = 0, tail = strNum.length();
		
	//	���и����Ͱٷ������
		if(strNum.length() > 0 && strNum.charAt(head) == '-') {
			++head;
			this.isPositive = false;
		}
		else {
			this.isPositive = true;
		}
		if(strNum.length() > 0 && strNum.charAt(tail - 1) == '%') {
			tail -= 3;
		//	Ĭ�Ͻ�ȥĩ��λ
			strNum = strNum.substring(head, tail);
		}
		
	//	��¼���ĳ��ȣ����Ƹ��źͰٷֺţ�
		this.arrayLength = tail - head;
		
	//	���ΰ��ַ��������������������
		for(int i = tail - 1,j = 0; i >= head; --i, ++j) {
			(this.arrayInt)[j] = Integer.parseInt("" + strNum.charAt(i));
		}
	}
}

class MyNaturalNumbers extends MyInteger {
	
//	MyNaturalNumbers���вι��캯�������ø���MyInteger���вι��캯��
	public MyNaturalNumbers(String strNum) {
		super(strNum);
	}
	
//	MyNaturalNumbers���вι��캯�������ø���MyInteger���вι��캯��
	public MyNaturalNumbers(MyInteger num) {
		super(num.toString());
	}
	
//	�ѵ�ǰ��MyNaturalNumber����󷵻�Ϊ��ֵ��MyInteger�����
	public MyInteger toMyInteger() {
		return new MyInteger(this.thisArrayToString());
	}
	
//	��һ��MyNaturalNumber����󷵻�Ϊ��ֵ��MyInteger�����
	public static MyInteger MyNaturalNumbersToMyInteger(MyNaturalNumbers my) {
		return new MyInteger(my.thisArrayToString());
	}
}