package experiment05;

import java.util.HashMap;

public class UseHashMap {
    public static void main(String args[]) {
    	
		HashMap<String, String> hScore = new HashMap<String, String>();
		
		hScore.put("张一", "86");
		hScore.put("李二", "98");
		hScore.put("海飞", "99");
		
		System.out.println("按字符串输出：" + hScore.toString());
		
		hScore.put("李二", "77");
		hScore.remove("张一");
		
		System.out.println("修改并删除之后");
		System.out.println("按字符串输出：" + hScore.toString());
    }
}
