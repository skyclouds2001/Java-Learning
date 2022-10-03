package experiment06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class ListOfNumbersDeclared {
    private ArrayList<Integer> list;
    private static final int size = 10;
    
    @SuppressWarnings("deprecation")
	public ListOfNumbersDeclared() {	//构造方法
        list = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++)
            list.add(new Integer(i));    }
    
    public void writeList() 
        throws IOException, IndexOutOfBoundsException {		//声明抛出异常
        PrintWriter out = new PrintWriter(new FileWriter("OutFile1.txt"));
        for (int i = 0; i < size; i++)
            out.println("Value at: " + i + " = " + list.get(i));
        out.close();    }
}

public class TestListOfNumbersDeclared {
    public static void main(String args[]) {
        try { 
        	ListOfNumbersDeclared list = new ListOfNumbersDeclared();
            list.writeList();
        } catch (Exception e) { }
       System.out.println("A list of numbers created and stored in OutFile1.txt");
    }
}

