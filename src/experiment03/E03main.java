package experiment03;

/*
	�����û��������������������
	�����û���������ڣ������������
*/

import java.util.Scanner;

public class E03main {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner input = new Scanner(System.in);
		int year = 0, month = 0, day = 0, tem = 0;
		//	�ж��Ƿ���Ҫ�˳�
		boolean isout = false;
		
		System.out.println("**************   Welcome to use the Calendar System   **************");
		System.out.println();
		
		while(!isout) {
			
			PrintMenu();
			System.out.print("��������룺");
			tem = input.nextInt();
			
			switch(tem) {
				case 0:
					isout = true;
					break;
				case 1:
					System.out.print("��������ݣ�");
					year = input.nextInt();
					System.out.print("�������·ݣ�");
					month = input.nextInt();
					System.out.print("���������ڣ�");
					day = input.nextInt();
					
					System.out.println("--------------------------------------------------------------------");
					System.out.printf("%d.%d.%d is %s\n", year, month, day, WeekString(FirstDayOfMonth(year, month, day)));
					System.out.println("--------------------------------------------------------------------");
					break;
				case 2:
					System.out.print("��������ݣ�");
					year = input.nextInt();
					System.out.println("--------------------------------------------------------------------");
					
					for(int i = 1; i <= 12; ++i) {
						PrintCalendar(year, i, FirstDayOfMonth(year, i, day));
						System.out.println();
						Thread.sleep(1000);
					}
					System.out.println("--------------------------------------------------------------------");
					break;
				default:
					System.out.println("�����ڲ�����");
					System.out.println("�������룡");
					break;
			}
			
			System.out.println();
			Thread.sleep(1000);
			
		}
		
		input.close();
		
	}
	
	public static void PrintCalendar(int year, int month, int weekcode) {
		
		System.out.printf("                 %3s                \n",MonthString(month));
		System.out.println("--------------------------------------");
		System.out.println("  һ    ��    ��    ��    ��    ��    ��  ");
		System.out.println("--------------------------------------");
		
//	�����ڲ���  1-����һ  2-���ڶ�  3-������  4-������  5-������  6-������  7-������
		int n = MonthLength(year, month);
		if(weekcode < 2)
			weekcode += 6;
		else
			weekcode -= 1;
		
		for(int i = 1; i<= weekcode && weekcode != 7; ++i)
			System.out.print("     ");
		int count = weekcode % 7 + 1;
		
		for(int k = 1; k <= n; ++k) {
			System.out.printf("%5d", k);
			++count;
			
			if(count > 7) {
				System.out.println();
				count -= 7;
			}
			
			if(k == n && count != 1)
				System.out.println();
		}
		
		System.out.println("--------------------------------------");
		System.out.println();
		
	}

//	����ֵ��0-������  1-������  2-����һ  3-���ڶ�  4-������  5-������  6-������
//	����һ�����㷨�������ڼ�
	public static int FirstDayOfMonth(int year, int month, int day) {
		
		int q = day;
		int m = month;
		int y = year;
		
		if(m <= 2) {
			m += 12;
			--y;
		}
		
		int j = y / 100;
		int k = y % 100;
		
		int h = (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
		
		return h;
		
	}

//	����˵�
	public static void PrintMenu() {
		
		System.out.println("********************************************************************");
		System.out.println("**********                 ���� 0 �Խ�������                 ***********");
		System.out.println("**********         ���� 1 ���������������Ӧ���������ڼ�          ***********");
		System.out.println("**********        ���� 2 �������ꡢ�¡��������Ӧ�������          ***********");
		System.out.println("********************************************************************");
		System.out.println();
		
	}
	
//	���ض�Ӧ��������ڼ��ַ���
	public static String WeekString(int code) {
		
		String w = "����";
		switch(code) {
			case 0:
				w += "��";
				break;
			case 1:
				w += "��";
				break;
			case 2:
				w += "һ";
				break;
			case 3:
				w += "��";
				break;
			case 4:
				w += "��";
				break;
			case 5:
				w += "��";
				break;
			case 6:
				w += "��";
				break;
		}
		return w;
		
	}

//	���ض�Ӧ������·��ַ���
	public static String MonthString(int code) {
		
		String s = "��";
		switch(code) {
			case 1:
				s = "һ" + s;
				break;
			case 2:
				s = "��" + s;
				break;
			case 3:
				s = "��" + s;
				break;
			case 4:
				s = "��" + s;
				break;
			case 5:
				s = "��" + s;
				break;
			case 6:
				s = "��" + s;
				break;
			case 7:
				s = "��" + s;
				break;
			case 8:
				s = "��" + s;
				break;
			case 9:
				s = "��" + s;
				break;
			case 10:
				s = "ʮ" + s;
				break;
			case 11:
				s = "ʮһ" + s;
				break;
			case 12:
				s = "ʮ��" + s;
				break;
		}
		return s;
		
	}

//	���ض�Ӧ�·�������
	public static int MonthLength(int year, int month) {
		
		int n = 0;
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				n = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				n = 30;
				break;
			case 2:
				n = (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)?29:28;
				break;
		}
		return n;
	}

}