package javastudyS10;

public class S1005 {

	public static void main(String[] args) {
		
		
		
	}

}

class Course {
	
	private String courseName;
	private String [] students;
	private int numberOfStudents;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void addStudent(String name) {
		(this.students)[this.numberOfStudents] = name;
		++this.numberOfStudents;
	}
	
	public void dropStudent() {
		
	}
	
	public int getNumberOfStudents() {
		return this.numberOfStudents;
	}
	
	public String [] getStudents() {
		return this.students;
	}
	
}
