package other;

import java.util.*;

public class W {
	static int id = 0;
	static String help = 
			"���Ķ�\n" + 
			"0�� ����\n" + 
			"1�� �洢��¼\n" + 
			"2�� չʾ���еļ�¼\n" + 
			"3�� չʾ��ѡ��ļ�¼\n" + 
			"4�� ɾ����ѡ��ļ�¼nt number of memo\n" +
			"5�� ����Ѿ��洢�ļ�¼����\n"+
			"6�� ɾ��ȫ���ļ�¼";
	
	public static void write(Map<Integer, String> memo, String memothing) {
		memo.put(id++, memothing);
		System.out.println("�����");
	}//��¼
	
	public static void GetId(Map<Integer, String> memo) {
		Iterator<Integer> iterator = memo.keySet().iterator();
		int id = 0;
		while(iterator.hasNext()) {
			id++;
		}
//		return id;
		System.out.println("���ڹ���¼"+id+"��");
	}////�������¼������
	
	
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
			System.out.println("δ�ҵ�������ݣ�");
		}
	}//�������¼������
	
	public static void ShowAllMemo(Map<Integer, String> memo) {
		Iterator<Integer> iterator = memo.keySet().iterator();
		while(iterator.hasNext()) {
			id = iterator.next();
			System.out.println(id +":"+ memo.get(id));
		}
	}//չʾ���м�¼����
	
	public static void DelTheMemo(Map<Integer, String> memo, int id) {
		String trush = memo.remove(id);
		if(trush == null) {
			System.out.println("�޷��Ƴ������ڵ�memo");
		}
		else {
			System.out.println("�Խ���"+ trush + "���Ƴ�");
		}
		
	}//ɾ��ѡ���ļ�¼����
	
	public static void main(String[] args) {
		
		Map<Integer, String> memo = new HashMap<Integer, String>();
		Scanner input = new Scanner(System.in);
		System.out.println("������0");
		String memothing = new String();
		
		while(true) {
			System.out.println("������ָ�");
			
			int a = input.nextInt();
			input.nextLine();
			
			if(a == 0) {			//����
				System.out.println(help);
			}
			else if(a == 1) {			//��¼
				System.out.println("������memo��");
				memothing= input.nextLine();
				write(memo, memothing);
			}
			else if(a == 2) {			//չʾ���м�¼����
				ShowAllMemo(memo);
			}
			else if(a == 3) {
				System.out.println("��������ҵ�memo���");
				id = input.nextInt();
				PrintTheMemo(memo, id);
			}
			else if(a == 4) {
				ShowAllMemo(memo);
				System.out.println("�������Ƴ���memo�ı��");
				id = input.nextInt();
				DelTheMemo(memo, id);
			}
			
			else if(a == 5) {			//�������¼������
				GetId(memo);
//				System.out.println("���ڹ���¼"+GetId(memo)+"��");
			}
            
			else {			//����
				System.out.println("�ѹرղ�����������ݣ�");
				break;
			}
		}
		
		input.close();
	}
}
