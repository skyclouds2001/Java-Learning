package experiment03;

public class E0343 {

	public static void main(String[] args) {
		
		byte b=2;
		char c='\u1234';
		int x=8,y=3;
		//byte b2 = -b; //intֵ����ֱ�Ӹ���byte���ͱ���b2
		//char c2 = +c; //intֵ����ֱ�Ӹ���char���ͱ���c2
		System.out.println((-b) + ";" + (+c));
		int i=~b;	//byteת��Ϊint
		System.out.println(Integer.toHexString(i));
		System.out.println(x/y);
		System.out.println(x/(float)y);

		
	}

}
