package javastudyS10;

import java.util.Arrays;

public class T1022_T1023_T1025 {

	public static void main(String[] args) {
		
		
		
	}

}

class MyString{
	
	private char [] pos = null;
	private int length = 0;
	
	private MyString() {
	}
	
	public MyString(char [] c) {
		this.pos = c.clone();
		this.length = c.length;
	}
	
	public MyString(String s) {
		this.pos = s.toCharArray();
		this.length = s.length();
	}
	
	public char charAt(int index) {
		return this.pos[index];
	}
	
	public int length() {
		return this.length;
	}
	
	public int compare(MyString ms) {
		return ms.pos.toString().compareTo(this.pos.toString());
	}
	
	public boolean equals(MyString ms) {
		return Arrays.equals(this.pos, ms.pos);
	}
	
	public MyString substring(int begin) {
		MyString ms = new MyString();
		ms.length = this.length - begin;
		ms.pos = new char[this.length - begin];
		System.arraycopy(ms.pos, 0, this.pos, begin, this.length - begin);
		return ms;
	}
	
	public MyString substring(int begin, int end) {
		MyString ms = new MyString();
		ms.length = end - begin;
		ms.pos = new char[end - begin];
		System.arraycopy(ms.pos, 0, this.pos, begin, end - begin);
		return ms;
	}
	
	public MyString toLowerCase(MyString ms) {
		return new MyString(ms.pos.toString().toLowerCase());
	}
	
	public MyString toUpperCase(MyString ms) {
		return new MyString(ms.pos.toString().toUpperCase());
	}
	
	public static MyString valueOf(int i) {
		Integer it = i;
		MyString ms = new MyString(it.toString());
		return ms;
	}
	
	public char [] toChars() {
		return this.pos.clone();
	}
	
	public static MyString valueOf(boolean b) {
		if(b) {
			return new MyString(new String("true"));
		}
		else {
			return new MyString(new String("false"));
		}
	}
	
}
