package javastudyS11;

public class T1102 {

	public static void main(String[] args) {
		
		System.out.println(new myPerson("S1", "R1", "1000", "1000@qq.com"));
		System.out.println(new myStudent("S2", "R2", "2000", "2000@qq.com", "Level1"));
		System.out.println(new myEmplyee("S3", "R3", "3000", "3000@qq.com", "O1", 5000, 2020, 9, 1));
		System.out.println(new myFaculty("S3", "R3", "3000", "3000@qq.com", "O1", 5000, 2020, 9, 1, "L1", "8:00-12:00&14:00-18:00"));
		System.out.println(new myStaff("S3", "R3", "3000", "3000@qq.com", "O1", 5000, 2020, 9, 1, "L2"));
		
	}

}
