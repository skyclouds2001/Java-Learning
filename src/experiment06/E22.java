package experiment06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class E22 {

	public static void main(String[] args) {
		E22 e22 = new E22();
		e22.writeList();
	}
	
	public void writeList() { 
	    
		PrintWriter out = null;
	    List<Integer> list =new ArrayList<Integer>();
	    final int size = 5;
	    
	    for(int i = 0; i < 5; ++i)
	    	list.add(i);
	    
	    try {
	        System.out.println("Entering try statement"); 
	        out=new PrintWriter(new FileWriter("OutFile.txt")); 
	        
	        for (int i=0;i<size;i++)
	            out.println("Value at: "+i+" = "+list.get(i)); 
	    } catch (IOException e) { 
	        System.err.println("Caught IOException: " + e.getMessage()); 
	    } catch (Exception e){ 
	        System.err.println("Caught Exception: "+e.getMessage()); 
	    } finally { 
	        if (out!=null) { 
	            System.out.println("Closing PrintWriter");
	            out.close(); 
	        } 
	        else { System.out.println("PrintWriter not open"); } 
	    } 
	}
}
