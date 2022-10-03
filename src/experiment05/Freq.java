package experiment05;

import java.util.Map;
import java.util.TreeMap;

public class Freq {
	public static void main(String args[]) {
		
		String[] words = { "if", "it", "is", "to", "be", "it", 
				"is", "up", "to", "me", "to", "delegate" };
		Integer freq;
		
		Map<String, Integer> m = new TreeMap<String, Integer>();
		
		for (String a : words) {//��(����,��Ƶ)Ϊ��ֵ��, ����Ƶ�ʱ�
			freq = m.get(a); // ��ȡָ�����ʵĴ�Ƶ��
			
			if (freq == null) { // ��Ƶ����
				freq = Integer.valueOf(1);
			} else {
				freq = Integer.valueOf(freq + 1);// .intValue()
			}
			
			m.put(a, freq); // ��Map�и��Ĵ�Ƶ
		}
		
		System.out.println(m.size() + " distinct words detected:");
		System.out.println(m);
	}
}

