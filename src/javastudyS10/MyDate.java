package javastudyS10;

class MyDate {
	
	private int year;
	private int month;
	private int day;
	
	public MyDate() {
	}
	public MyDate(long miniSeconds) {
//		long seconds = miniSeconds / 1000;
//		long minutes = seconds / 60;
//		long hours = minutes / 60;
//		long days = hours / 24;
	}
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear() {
		return this.year;
	}
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
	}
	
}
