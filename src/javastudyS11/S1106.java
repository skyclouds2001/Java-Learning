package javastudyS11;

public class S1106 {

	public static void main(String[] args) {
		System.out.println(new GradualStudent());
		System.out.println(new Student());
		System.out.println(new Person());
		System.out.println(new Object());
	}

}

class Person extends Object {
	public int num = 100;
	public String toString() {
		return "Person";
	}
	public boolean equals(Object o) {
		if(o instanceof Person)
			return this.num == ((Person)o).num;
		else
			return this == o;
	}
}

class Student extends Person {
	public String toString() {
		return "Student";
	}
}

class GradualStudent extends Student {
	
}
