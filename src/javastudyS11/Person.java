package javastudyS11;

class myPerson {

	private final String name;
	private final String address;
	private final String phone;
	private final String email;
	
	public myPerson(String name, String address, String phone, String email) {
		this.name = new String(name);
		this.address = new String(address);
		this.phone = new String(phone);
		this.email = new String(email);
	}
	
	public String toString() {
		String s = new String(this.getClass().getName());
		s = s + " " + this.name + " " + this.address + " " + this.phone + " " + this.email;
		return s;
	}
	
	public String getName() {
		return new String(this.name);
	}
	public String getAddress() {
		return new String(this.address);
	}
	public String getPhone() {
		return new String(this.phone);
	}
	public String getEmail() {
		return new String(this.email);
	}

}
