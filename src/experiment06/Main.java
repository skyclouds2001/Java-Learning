package experiment06;

public class Main {

	public static void main(String[] args) throws DataException {
		boolean isSucceed = true;
		
		try {
			MyNaturalInteger.getInstance("-100");
		} catch(DataException de) {
			System.out.println(de);
			isSucceed = false;
		}
		
		if(isSucceed)
			System.out.println("Succeeded!");
		else
			System.out.println("Failed!");
	}

}

class DataException extends Exception{

	private static final long serialVersionUID = 2721724567800768435L;
	String reason;

	public DataException(String reason) {
		this.reason = new String(reason);
	}
	
	public String getReason() {
		return this.reason;
	}
	
	public String toString() {
		return "DataException: " + reason;
	}
}

class MyNaturalInteger {

//	����ÿ�ε���󳤶ȣ�100�����쳤����ʱ�����ӳ�
//	����Ϊ��̬int���ͳ�Ա����
	protected final static int ARRAY_PER_LENGTH = 100;

//	������Сint�ͱ�����ֵ
	protected final static int MAX_INT_VALUE = 2147483647;
	protected final static int MIN_INT_VALUE = 0;

//	�Դ洢�������������
	protected int [] arrayInt;
//	��������Ƿ���������    true����������false��������
	protected boolean isPositive;

//	�洢�������������ARRAY_PER_LENGTH������������
	protected int arrayCapacity;
//	�洢���ĳ��ȣ�������λ�������Ƹ��ţ�
	protected int arrayLength;

	public static MyNaturalInteger getInstance(int num) throws DataException {
		if(num < 0)
			throw new DataException("Negative Number!");
		else
			return new MyNaturalInteger(num);
	}

	public static MyNaturalInteger getInstance(String num) throws DataException {
		if(num.charAt(0) == '-')
			throw new DataException("Negative Number!");
		else
			return new MyNaturalInteger(num);
	}

//	MyInteger�๹�캯����ͨ�����ִ���MyInteger�����
	private MyNaturalInteger(int num) {
		this.stringToThisArray((Integer.valueOf(num)).toString());
	}

//	MyInteger�๹�캯����ͨ�������ַ�������MyInteger�����
	private MyNaturalInteger(String strNum) {
		this.stringToThisArray(strNum);
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
		return (this.thisArrayToString() == ((MyNaturalInteger)my).thisArrayToString());
	}

//	���ش洢���������ַ�����ʽ����
//	��дObject���toString()����
//	����thisArrayToString()����
	public String toString() {
		return this.thisArrayToString();
	}

//	�ӷ�������
	public MyNaturalInteger add(MyNaturalInteger my) {
		MyNaturalInteger ans = new MyNaturalInteger("");
		
	//  ������ͬ�����������ӣ����Ų���
		if(this.isPositive == my.isPositive) {
			
			ans = MyNaturalInteger.addBase(this, my);
			ans.isPositive = this.isPositive;
		}
	//  ���Ų�ͬ�����
		else {
			
		//  ���Ų�ͬ�����ǰΪ����
		//	��ǰ��С�ں������൱�ں�����ǰ����ȡ�෴�������Ϊ����
			if(this.isPositive && MyNaturalInteger.compare(this, my) == -1) {
				ans = MyNaturalInteger.subBase(my, this);
				ans.isPositive = false;
			}
		//  ��ǰ�����ڵ��ں�����������������Ϊ��
			else if(this.isPositive && MyNaturalInteger.compare(this, my) != -1) {
				ans = MyNaturalInteger.subBase(this, my);
				ans.isPositive = true;
			}
		//  ���Ų�ͬ����Һ�Ϊ����
		//  ���������ڵ���ǰ����������������Ϊ��
			else if(my.isPositive && MyNaturalInteger.compare(this, my) == -1) {
				ans = MyNaturalInteger.subBase(my, this);
				ans.isPositive = true;
			}
		//  ������С��ǰ�����൱��ǰ����������ȡ�෴�������Ϊ��
			else if(my.isPositive && MyNaturalInteger.compare(this, my) != -1) {
				ans = MyNaturalInteger.subBase(this, my);
				ans.isPositive = false;
			}
		}
		
		return ans;
	}

//	����������
	public MyNaturalInteger sub(MyNaturalInteger my) {
		MyNaturalInteger ans = new MyNaturalInteger("");
		
	//  ������ͬ���������Ϊ����
		if(this.isPositive && my.isPositive) {
		//  ��ǰ��С�ں������൱�ں�����ǰ����ȡ�෴�������Ϊ��
			if(MyNaturalInteger.compare(this, my) == -1) {
				ans = MyNaturalInteger.subBase(my, this);
				ans.isPositive = false;
			}
		//  ��ǰ�����ڵ��ں�����������������Ϊ��
			else {
				ans = MyNaturalInteger.subBase(this, my);
				ans.isPositive = true;
			}
		}
	//  ������ͬ���������Ϊ����
		else if(!this.isPositive && !my.isPositive) {
		//  ������С��ǰ�����൱��ǰ����������ȡ�෴�������Ϊ��
			if(MyNaturalInteger.compare(this, my) != -1) {
				ans = MyNaturalInteger.subBase(this, my);
				ans.isPositive = false;
			}
		//  ���������ڵ���ǰ����������������Ϊ��
			else {
				ans = MyNaturalInteger.subBase(my, this);
				ans.isPositive = true;
			}
		}
	//  ���Ų�ͬ���
		else {
			ans = MyNaturalInteger.addBase(this, my);
			
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
	static protected MyNaturalInteger addBase(MyNaturalInteger m1, MyNaturalInteger m2) {
		
		MyNaturalInteger ans = new MyNaturalInteger("");
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
	static protected MyNaturalInteger subBase(MyNaturalInteger m1, MyNaturalInteger m2) {
		
		MyNaturalInteger ans = new MyNaturalInteger("");
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
	static protected int compare(MyNaturalInteger n1, MyNaturalInteger n2) {
		
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
