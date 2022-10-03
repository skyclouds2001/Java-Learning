package experiment03;

class Value {
	int i;
	public boolean equals(Value v) {
		return (this.i == v.i) ? true : false;
	}
}
public class E0348 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Integer n1=new Integer(47);
		Integer n2=new Integer(47); 
		System.out.println("n1==n2: "+ (n1==n2)); //对引用的比较
		System.out.println("n1!=n2: "+ (n1!=n2));
		System.out.println("n1.equals(n2): "+ n1.equals(n2));
			//Integer已重写equals()
 		Value v1 = new Value(); Value v2 = new Value();
		v1.i = v2.i = 10;
		System.out.println("v1.equals(v2): " + v1.equals(v2));
	}
}

