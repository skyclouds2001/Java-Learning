package experiment05;

import java.util.HashMap;

public class UseHashMap {
    public static void main(String args[]) {
    	
		HashMap<String, String> hScore = new HashMap<String, String>();
		
		hScore.put("��һ", "86");
		hScore.put("���", "98");
		hScore.put("����", "99");
		
		System.out.println("���ַ��������" + hScore.toString());
		
		hScore.put("���", "77");
		hScore.remove("��һ");
		
		System.out.println("�޸Ĳ�ɾ��֮��");
		System.out.println("���ַ��������" + hScore.toString());
    }
}
