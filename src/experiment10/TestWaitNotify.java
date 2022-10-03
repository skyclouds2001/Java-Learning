package experiment10;

import java.util.Vector;

public class TestWaitNotify {

	public static void main(String[] args) {
		SyncStack sc = new SyncStack();
		for(int i = (int)'a'; i <= (int)'z'; ++i) {
			sc.push((char)i);
			System.out.println(sc.pop());
		}
	}
}

class SyncStack{
	private Vector<Character> buffer = new Vector<>(100000);
	
	public synchronized  char  pop( ){
	    char c ;
	    while(buffer.size( ) ==0){
	    	try{  this.wait( );
		}catch(InterruptedException e){  }
	    }
	    c=( (Character)buffer.remove(buffer.size( )-1)).charValue();
	    return c ;
	}

	public synchronized  void  push(char c){
		this.notify();
		Character charObj = c;
		buffer.addElement( charObj);
	}
}

