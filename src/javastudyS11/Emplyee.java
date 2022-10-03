package javastudyS11;

import java.util.Date;

class myEmplyee extends myPerson{
	
	private final String office;
	private final int pay;
	private final Date hireDate;
	
	@SuppressWarnings("deprecation")
	public myEmplyee(String name, String address, String phone, String email, String office, int pay,
				int hireDateYear, int hireDateMonth, int hireDateDay) {
		super(name, address, phone, email);
		this.office = new String(office);
		this.pay = pay;
		this.hireDate = new Date(hireDateYear, hireDateMonth, hireDateDay);
	}
	
	public String toString() {
		return new String(super.toString() + " " + this.office + " " + String.valueOf(this.pay) + " " + this.hireDate.toString());
	}
	
	public String getOffice() {
		return new String(office);
	}
	public int getPay() {
		return pay;
	}
	public Date getGrade() {
		return (Date)(hireDate.clone());
	}
	
}
