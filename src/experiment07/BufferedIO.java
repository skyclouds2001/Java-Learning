package experiment07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedIO{
	public static void main(String[] args) throws IOException{
		
		BufferedReader in=new BufferedReader(
				new FileReader("1.txt"));
		PrintWriter out=new PrintWriter( new BufferedWriter(
				new FileWriter("2.txt")));
		String s;
		int linecnt=1;
		StringBuilder sb=new StringBuilder();
		
		while((s=in.readLine())!=null){
			sb.append(linecnt+":"+s+"\n");
			out.println(linecnt+":"+s);
			linecnt++;
		}
		
		in.close();
		out.close();
		System.out.print(sb.toString());
	}
}

