package experiment04;

public class E0472 {
	public static void main(String[] args) {
		Student0 stu=new Student0();
		System.out.println(stu.getName()+" , "+stu.getID());
	}
}
class Student0 {
	private String name;
	private String id;
	public Student0(String nm, String id) {
		this.name=nm;
		this.id=id;
	}
	public Student0(String nm) {
		this(nm,"00000000");
	}
	public Student0() {
		this("Unknown");
	}
	public String getName() {
		return name;
	}
	public String getID() {
		return id;
	}
}

