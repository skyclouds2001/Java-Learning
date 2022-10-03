package experiment07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializeDate {
	SerializeDate( ){
		Date d = new Date( );
		try {
			ObjectOutputStream s= new ObjectOutputStream(
					new FileOutputStream("date.ser"));
			s.writeObject(d);
			s.close( );
		}catch( IOException e){
			e.printStackTrace( );
		}
	}
	public static void main(String args[]){
		@SuppressWarnings("unused")
		SerializeDate b = new SerializeDate();
	}
}
