package experiment03;

/*
	根据用户输入的年份输出该年日历
	根据用户输入的日期，输出该天星期
*/

import java.util.Scanner;

public class E03main {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner input = new Scanner(System.in);
		int year = 0, month = 0, day = 0, tem = 0;
		//	判断是否需要退出
		boolean isout = false;
		
		System.out.println("**************   Welcome to use the Calendar System   **************");
		System.out.println();
		
		while(!isout) {
			
			PrintMenu();
			System.out.print("请输入编码：");
			tem = input.nextInt();
			
			switch(tem) {
				case 0:
					isout = true;
					break;
				case 1:
					System.out.print("请输入年份：");
					year = input.nextInt();
					System.out.print("请输入月份：");
					month = input.nextInt();
					System.out.print("请输入日期：");
					day = input.nextInt();
					
					System.out.println("--------------------------------------------------------------------");
					System.out.printf("%d.%d.%d is %s\n", year, month, day, WeekString(FirstDayOfMonth(year, month, day)));
					System.out.println("--------------------------------------------------------------------");
					break;
				case 2:
					System.out.print("请输入年份：");
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
					System.out.println("不存在操作！");
					System.out.println("请检查输入！");
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
		System.out.println("  一    二    三    四    五    六    日  ");
		System.out.println("--------------------------------------");
		
//	函数内部：  1-星期一  2-星期二  3-星期三  4-星期四  5-星期五  6-星期六  7-星期日
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

//	返回值：0-星期六  1-星期日  2-星期一  3-星期二  4-星期三  5-星期四  6-星期五
//	泽勒一致性算法计算星期几
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

//	输出菜单
	public static void PrintMenu() {
		
		System.out.println("********************************************************************");
		System.out.println("**********                 输入 0 以结束程序                 ***********");
		System.out.println("**********         输入 1 以输入日期输出对应日期是星期几          ***********");
		System.out.println("**********        输入 2 以输入年、月、日输出对应年的日历          ***********");
		System.out.println("********************************************************************");
		System.out.println();
		
	}
	
//	返回对应编码的星期几字符串
	public static String WeekString(int code) {
		
		String w = "星期";
		switch(code) {
			case 0:
				w += "六";
				break;
			case 1:
				w += "日";
				break;
			case 2:
				w += "一";
				break;
			case 3:
				w += "二";
				break;
			case 4:
				w += "三";
				break;
			case 5:
				w += "四";
				break;
			case 6:
				w += "五";
				break;
		}
		return w;
		
	}

//	返回对应编码的月份字符串
	public static String MonthString(int code) {
		
		String s = "月";
		switch(code) {
			case 1:
				s = "一" + s;
				break;
			case 2:
				s = "二" + s;
				break;
			case 3:
				s = "三" + s;
				break;
			case 4:
				s = "四" + s;
				break;
			case 5:
				s = "五" + s;
				break;
			case 6:
				s = "六" + s;
				break;
			case 7:
				s = "七" + s;
				break;
			case 8:
				s = "八" + s;
				break;
			case 9:
				s = "九" + s;
				break;
			case 10:
				s = "十" + s;
				break;
			case 11:
				s = "十一" + s;
				break;
			case 12:
				s = "十二" + s;
				break;
		}
		return s;
		
	}

//	返回对应月份日期数
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