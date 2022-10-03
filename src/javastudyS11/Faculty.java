package javastudyS11;

class myFaculty extends myEmplyee {
	
	private final String level;
	private final String workingTime;
	
	public myFaculty(String name, String address, String phone, String email, String office, int pay,
				int hireDateYear, int hireDateMonth, int hireDateDay, String level, String workingTime) {
		super(name, address, phone, email, office, pay, hireDateYear, hireDateMonth, hireDateDay);
		this.level = level;
		this.workingTime = workingTime;
	}
	
	public String toString() {
		return (super.toString() + " " + this.level + " " + this.workingTime);
	}
	
	public String getLevel() {
		return this.level;
	}
	public String getWorkingTime() {
		return this.workingTime;
	}
	
}
