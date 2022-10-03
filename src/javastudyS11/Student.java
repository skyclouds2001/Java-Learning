package javastudyS11;

class myStudent extends myPerson{

	private final String grade;
	
	myStudent(String name, String address, String phone, String email, String grade) {
		super(name, address, phone, email);
		this.grade = new String(grade);
	}
	
	public String toString() {
		return new String(super.toString() + " " + this.grade);
	}
	
	public String getGrade() {
		return new String(grade);
	}

}
