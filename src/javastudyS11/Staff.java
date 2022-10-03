package javastudyS11;

class myStaff extends myEmplyee {

	private final String designation;
	
	public myStaff(String name, String address, String phone, String email, String office, int pay,
			int hireDateYear, int hireDateMonth, int hireDateDay, String designation) {
		super(name, address, phone, email, office, pay, hireDateYear, hireDateMonth, hireDateDay);
		this.designation = new String(designation);
	}
	
	public String toString() {
		return (super.toString() + " " + this.designation);
	}
	
	public String getDesignation() {
		return this.designation;
	}
	
}
