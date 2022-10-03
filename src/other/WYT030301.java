package other;

public class WYT030301 {

	public static void main(String[] args) {

		int year = 0, month = 0, day = 0;
		if(args.length == 3) {
			month = Integer.valueOf(args[0]).intValue();
			day = Integer.valueOf(args[1]).intValue();
			year = Integer.valueOf(args[2]).intValue();
			System.out.println(WeekString(FirstDayOfMonth(year, month, day)));
		}
		else if(args.length == 2) {
			month = Integer.valueOf(args[0]).intValue();
			year = Integer.valueOf(args[1]).intValue();
			PrintCalendar(year, month, FirstDayOfMonth(year, month, 1));
		}
		else {
			System.out.println("Unfair Input！");
		}
		
	}
	
	private static void PrintCalendar(int year, int month, int weekcode) {

		System.out.println(MonthString(month) + " " + year);
		System.out.println("   Su   Mo   Tu   We   Th   Fr   Sa");

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

		System.out.println();
		
	}

//	返回值：0-星期六  1-星期日  2-星期一  3-星期二  4-星期三  5-星期四  6-星期五
//	泽勒一致性算法计算星期几
	private static int FirstDayOfMonth(int year, int month, int day) {

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

	private static final String [] weekID = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
//	返回对应编码的星期几字符串
	private static String WeekString(int code) {
		return weekID[code];
	}

	private static final String [] month = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
//	返回对应编码的月份字符串
	private static String MonthString(int code) {
		return month[code - 1] ;
	}

//	返回对应月份日期数
	private static int MonthLength(int year, int month) {
		
		int n = 0;
		switch(month) {
			case 1:  case 3:  case 5:  case 7:  case 8:  case 10:  case 12:
				n = 31;
				break;
			case 4:  case 6:  case 9:  case 11:
				n = 30;
				break;
			case 2:
				n = (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)? 29: 28;
				break;
		}
		return n;
	}

}
