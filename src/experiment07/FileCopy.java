package experiment07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy{
    public static void main(String[] args) throws IOException{
            
    	FileInputStream in=new FileInputStream("1.txt");
        FileOutputStream out=new FileOutputStream("2.txt");
        int c;
        
        while( (c=in.read()) != -1)
        	out.write(c);
        
        in.close();
        out.close();
    }
}
