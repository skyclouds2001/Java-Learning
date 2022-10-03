package experiment04;

public class T1 {

	static float ptValue;
	
	public static void changeObjValue() {
		ptValue = 99.0f;
	}
	
	public static void main(String args[]) {
		
		ptValue = 101.0f;
		changeObjValue();
		System.out.println("Pt value is: " + ptValue);
	}

}
