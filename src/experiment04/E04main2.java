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
		System.out.println("Integer1 为 " + i1.getInteger());
		System.out.println("Integer1 的长度为 " + i1.arrayLength);
		System.out.println("Integer2 为 " + i2.getInteger());
		System.out.println("Integer2 的长度为 " + i2.arrayLength);
		
		System.out.println("Integer1 和 Integer2 的和为 " + (i1.add(i2)).getInteger());
		System.out.println("Integer1 和 Integer2 的差为 " + (i1.sub(i2)).getInteger());
		
		System.out.println("Integer1 和 Integer2 的比较 " + i1.equals(i2));
		
		input.close();
	}

}

class MyInteger {
	
//	数组每段的最大长度（100），伸长数组时按段延长
//	定义为静态int类型成员常量
	protected final static int ARRAY_PER_LENGTH = 100;
	
//	最大和最小int型变量的值
	protected final static int MAX_INT_VALUE = 2147483647;
	protected final static int MIN_INT_VALUE = -2147483648;
	
//	对存储数的数组的引用
	protected int [] arrayInt;
//	标记数字是否是正数：    true【正数】；false【负数】
	protected boolean isPositive;
	
//	存储数组的容量（是ARRAY_PER_LENGTH的正整数倍）
	protected int arrayCapacity;
//	存储数的长度，即数的位数（不计负号）
	protected int arrayLength;
	
	
//	MyInteger类构造函数，通过给定数字字符串创建MyInteger类对象
	public MyInteger(String strNum) {
		this.stringToThisArray(strNum);
	}
	
//	MyInteger类构造函数，通过MyNaturalNumbers类对象创建MyInteger类对象
	public MyInteger(MyNaturalNumbers num) {
		this.stringToThisArray(num.toString());
	}
	
//	返回存储在类内的数：以字符串形式返回
//	调用thisArrayToString()方法
	public String getInteger() {
		return this.thisArrayToString();
	}
	
//	向类中存储数：以字符串形式输入
//	调用stringToThisArray()方法
	public void setInteger(String strNum){
		this.stringToThisArray(strNum);
	}
	
//	比较两个MyInteger类的数是否相等
//	重写Object类的equals()方法
//	调用thisArrayToString()方法
	public boolean equals(Object my) {
		return (this.thisArrayToString() == ((MyInteger)my).thisArrayToString());
	}
	
//	返回存储的数：以字符串形式返回
//	重写Object类的toString()方法
//	调用thisArrayToString()方法
	public String toString() {
		return this.thisArrayToString();
	}
	
//	加法主方法
	public MyInteger add(MyInteger my) {
		MyInteger ans = new MyInteger("");
		
	//  符号相同情况：两数相加，符号不变
		if(this.isPositive == my.isPositive) {
			
			ans = MyInteger.addBase(this, my);
			ans.isPositive = this.isPositive;
		}
	//  符号不同情况：
		else {
			
		//  符号不同情况，前为正：
		//	若前数小于后数：相当于后数减前数再取相反数，结果为负：
			if(this.isPositive && MyInteger.compare(this, my) == -1) {
				ans = MyInteger.subBase(my, this);
				ans.isPositive = false;
			}
		//  若前数大于等于后数：正常相减，结果为正
			else if(this.isPositive && MyInteger.compare(this, my) != -1) {
				ans = MyInteger.subBase(this, my);
				ans.isPositive = true;
			}
		//  符号不同情况且后为正：
		//  若后数大于等于前数：正常相减，结果为正
			else if(my.isPositive && MyInteger.compare(this, my) == -1) {
				ans = MyInteger.subBase(my, this);
				ans.isPositive = true;
			}
		//  若后数小于前数：相当于前数减后数再取相反数，结果为负
			else if(my.isPositive && MyInteger.compare(this, my) != -1) {
				ans = MyInteger.subBase(this, my);
				ans.isPositive = false;
			}
		}
		
		return ans;
	}
	
//	减法主方法
	public MyInteger sub(MyInteger my) {
		MyInteger ans = new MyInteger("");
		
	//  符号相同情况且两数为正：
		if(this.isPositive && my.isPositive) {
		//  若前数小于后数：相当于后数减前数再取相反数，结果为负
			if(MyInteger.compare(this, my) == -1) {
				ans = MyInteger.subBase(my, this);
				ans.isPositive = false;
			}
		//  若前数大于等于后数：正常相减，结果为正
			else {
				ans = MyInteger.subBase(this, my);
				ans.isPositive = true;
			}
		}
	//  符号相同情况且两数为负：
		else if(!this.isPositive && !my.isPositive) {
		//  若后数小于前数：相当于前数减后数再取相反数，结果为负
			if(MyInteger.compare(this, my) != -1) {
				ans = MyInteger.subBase(this, my);
				ans.isPositive = false;
			}
		//  若后数大于等于前数：正常相减，结果为正
			else {
				ans = MyInteger.subBase(my, this);
				ans.isPositive = true;
			}
		}
	//  符号不同情况
		else {
			ans = MyInteger.addBase(this, my);
			
		//  符号不同情况且前数为正：正常相加，结果为正
			if(this.isPositive)
				ans.isPositive = true;
		//  符号不同情况且前数为负：正常相加，结果为负
			else
				ans.isPositive = false;
		}
		
		return ans;
	}
 	
//	基本加法方法，不考虑符号
//  完成相加，长度指定，容量指定
	static protected MyInteger addBase(MyInteger m1, MyInteger m2) {
		
		MyInteger ans = new MyInteger("");
		int maxlen = m2.arrayLength > m1.arrayLength ? m2.arrayLength : m1.arrayLength;
		ans.arrayCapacity = (maxlen / ARRAY_PER_LENGTH + 2) * ARRAY_PER_LENGTH;
		ans.arrayInt = new int[m1.arrayCapacity];
		
	//  按位相加，考虑进位
		int i = 0;
		for(; i <= maxlen; ++i) {
			(ans.arrayInt)[i] += (m2.arrayInt)[i] + (m1.arrayInt)[i];
			(ans.arrayInt)[i + 1] += (ans.arrayInt)[i] / 10;
			(ans.arrayInt)[i] %= 10;
		}
		
	//  考虑相加后新数长度 
		if((ans.arrayInt)[i] != 0)
			ans.arrayLength = i;
		else
			ans.arrayLength = i - 1;
		
		return ans;
	}
	
//	基本减法方法，不考虑符号
//	默认:m1中的数绝对值大于m2中的数绝对值
//  完成相加，长度指定，容量指定
	static protected MyInteger subBase(MyInteger m1, MyInteger m2) {
		
		MyInteger ans = new MyInteger("");
		int maxlen = m1.arrayLength >= m2.arrayLength ? m1.arrayLength : m2.arrayLength;
		ans.arrayCapacity = (maxlen / ARRAY_PER_LENGTH + 2) * ARRAY_PER_LENGTH;
		ans.arrayInt = new int[ans.arrayCapacity];
		
	//  按位相减，不足退位
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
		
	//  考虑相减后新数长度
		while((ans.arrayInt)[i] == 0 && i > 0)
			--i;
		ans.arrayLength = i + 1;
		
		return ans;
	}
	
//  比较两类大整数绝对值大小函数
//  返回1代表n1>n2,返回0代表n1=n2,返回-1代表n1<n2
	static protected int compare(MyInteger n1, MyInteger n2) {
		
	//  先比较长度大小 
		if(n1.arrayLength > n2.arrayLength)
			return 1;
		else if(n1.arrayLength < n2.arrayLength)
			return -1;
	//  相同长度大小再逐位比较 
		else {
			
			for(int i = n1.arrayLength - 1; i >= 0; --i) {
				
				if((n1.arrayInt)[i] > (n2.arrayInt)[i]) {
					return 1;
				}
				else if((n1.arrayInt)[i] < (n2.arrayInt)[i]) {
					return -1;
				}
			}
			
		// 完全相同返回0
			return 0;
		}
	}
	
//	基础方法：把类内存储的数转为字符串输出
	protected String thisArrayToString() {
		String strNum = new String();
		
	//	依次把数组中数取出并转入字符串
		for(int i = 0; i < this.arrayLength; ++i)
			strNum = String.valueOf(this.arrayInt[i]) + strNum;
		
	//	特判负数情况
		if(!this.isPositive)
			strNum = "-" + strNum;
		
		return strNum.strip();
	}

//	基础方法：把字符串存储至类内
	protected void stringToThisArray(String strNum) {
		
	//	计算并记录应重新开辟数组的容量
	//	保证大于数的位数且有足够的多余容量
		int num = (strNum.length() / ARRAY_PER_LENGTH + 2) * ARRAY_PER_LENGTH;
		this.arrayInt = new int[num];
		this.arrayCapacity = num;
	//	处理千分号情况
		for(int p = strNum.indexOf(','); p != -1; p = strNum.indexOf(',')) {
			strNum = strNum.substring(0, p) + strNum.substring(p + 1, strNum.length());
		}
		
		int head = 0, tail = strNum.length();
		
	//	特判负数和百分数情况
		if(strNum.length() > 0 && strNum.charAt(head) == '-') {
			++head;
			this.isPositive = false;
		}
		else {
			this.isPositive = true;
		}
		if(strNum.length() > 0 && strNum.charAt(tail - 1) == '%') {
			tail -= 3;
		//	默认截去末两位
			strNum = strNum.substring(head, tail);
		}
		
	//	记录数的长度（不计负号和百分号）
		this.arrayLength = tail - head;
		
	//	依次把字符串型数按倒序存入数组
		for(int i = tail - 1,j = 0; i >= head; --i, ++j) {
			(this.arrayInt)[j] = Integer.parseInt("" + strNum.charAt(i));
		}
	}
}

class MyNaturalNumbers extends MyInteger {
	
//	MyNaturalNumbers类有参构造函数，调用父类MyInteger的有参构造函数
	public MyNaturalNumbers(String strNum) {
		super(strNum);
	}
	
//	MyNaturalNumbers类有参构造函数，调用父类MyInteger的有参构造函数
	public MyNaturalNumbers(MyInteger num) {
		super(num.toString());
	}
	
//	把当前的MyNaturalNumber类对象返回为等值的MyInteger类对象
	public MyInteger toMyInteger() {
		return new MyInteger(this.thisArrayToString());
	}
	
//	把一个MyNaturalNumber类对象返回为等值的MyInteger类对象
	public static MyInteger MyNaturalNumbersToMyInteger(MyNaturalNumbers my) {
		return new MyInteger(my.thisArrayToString());
	}
}