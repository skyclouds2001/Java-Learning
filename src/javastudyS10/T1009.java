package javastudyS10;

public class T1009 {

	public static void main(String[] args) {
		
		pCourse c = new pCourse("Math");
		
		c.addStudent("Jack");
		c.addStudent("Mike");
		c.addStudent("Karl");
		
		c.dropStudent("Mike");
		
		for(String ss : c.getStudents()) {
			System.out.println(ss);
		}
		
	}

}

class pCourse {
	
	private String courseName;
	private String [] students;
	private int numberOfStudents;
	private int size;
	
	public pCourse(String courseName) {
		this.courseName = courseName;
		this.size = 100;
		this.students = new String[this.size];
		this.numberOfStudents = 0;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void addStudent(String name) {
		
		if(this.numberOfStudents == this.size) {
			this.size *= 2;
			String [] s = new String[this.size];
			
			for(int i = 0; i < this.numberOfStudents; ++i) {
				s[i] = (this.students)[i];
			}
			
			this.students = s;
		}
		
		
		(this.students)[this.numberOfStudents] = name;
		++this.numberOfStudents;
	}
	
	public void dropStudent(String name) {
		
		String [] s = new String[this.size];
		boolean isFound = false;
		
		for(int i = 0, j = 0; i < this.numberOfStudents; ++i) {
			
			if(!(this.students)[i].equals(name)) {
				s[j] = (this.students)[i];
				++j;
			}
			else {
				isFound = true;
			}
			
		}
		
		this.students = s;
		if(isFound)
			--this.numberOfStudents;
		
	}
	
	public int getNumberOfStudents() {
		return this.numberOfStudents;
	}
	
	public String [] getStudents() {
		String [] get = new String[this.numberOfStudents];
		
		for(int i = 0; i < this.numberOfStudents; ++i) {
			get[i] = (this.students)[i];
		}
		
		return get;
	}
	
}