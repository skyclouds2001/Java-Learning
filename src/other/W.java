package other;

import java.util.*;

public class W {
	static int id = 0;
	static String help = 
			"请阅读\n" + 
			"0： 帮助\n" + 
			"1： 存储记录\n" + 
			"2： 展示所有的记录\n" + 
			"3： 展示所选择的记录\n" + 
			"4： 删除所选择的记录nt number of memo\n" +
			"5： 获得已经存储的记录数量\n"+
			"6： 删除全部的记录";
	
	public static void write(Map<Integer, String> memo, String memothing) {
		memo.put(id++, memothing);
		System.out.println("已添加");
	}//记录
	
	public static void GetId(Map<Integer, String> memo) {
		Iterator<Integer> iterator = memo.keySet().iterator();
		int id = 0;
		while(iterator.hasNext()) {
			id++;
		}
//		return id;
		System.out.println("现在共记录"+id+"个");
	}////获得所记录的数量
	
	
	public static void PrintTheMemo(Map<Integer, String> memo, int id) {
		Iterator<Integer> iterator = memo.keySet().iterator();
		boolean checked = false;
		while(iterator.hasNext()) {
			if(iterator.next() == id) {
				System.out.println(memo.get(id));
				checked = true;
			}
		}
		if(!checked) {
			System.out.println("未找到相关内容！");
		}
	}//输出所记录的内容
	
	public static void ShowAllMemo(Map<Integer, String> memo) {
		Iterator<Integer> iterator = memo.keySet().iterator();
		while(iterator.hasNext()) {
			id = iterator.next();
			System.out.println(id +":"+ memo.get(id));
		}
	}//展示所有记录内容
	
	public static void DelTheMemo(Map<Integer, String> memo, int id) {
		String trush = memo.remove(id);
		if(trush == null) {
			System.out.println("无法移除不存在的memo");
		}
		else {
			System.out.println("以将“"+ trush + "”移除");
		}
		
	}//删除选定的记录内容
	
	public static void main(String[] args) {
		
		Map<Integer, String> memo = new HashMap<Integer, String>();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入0");
		String memothing = new String();
		
		while(true) {
			System.out.println("请输入指令：");
			
			int a = input.nextInt();
			input.nextLine();
			
			if(a == 0) {			//帮助
				System.out.println(help);
			}
			else if(a == 1) {			//记录
				System.out.println("请输入memo：");
				memothing= input.nextLine();
				write(memo, memothing);
			}
			else if(a == 2) {			//展示所有记录内容
				ShowAllMemo(memo);
			}
			else if(a == 3) {
				System.out.println("请输入查找的memo编号");
				id = input.nextInt();
				PrintTheMemo(memo, id);
			}
			else if(a == 4) {
				ShowAllMemo(memo);
				System.out.println("请输入移除的memo的编号");
				id = input.nextInt();
				DelTheMemo(memo, id);
			}
			
			else if(a == 5) {			//获得所记录的数量
				GetId(memo);
//				System.out.println("现在共记录"+GetId(memo)+"个");
			}
            
			else {			//结束
				System.out.println("已关闭并清除所有数据！");
				break;
			}
		}
		
		input.close();
	}
}
