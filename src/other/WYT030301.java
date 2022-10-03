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
			System.out.println("Unfair Input��");
		}
		
	}
	
	private static void PrintCalendar(int year, int month, int weekcode) {

		System.out.println(MonthString(month) + " " + year);
		System.out.println("   Su   Mo   Tu   We   Th   Fr   Sa");

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

		System.out.println();
		
	}

//	����ֵ��0-������  1-������  2-����һ  3-���ڶ�  4-������  5-������  6-������
//	����һ�����㷨�������ڼ�
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
//	���ض�Ӧ��������ڼ��ַ���
	private static String WeekString(int code) {
		return weekID[code];
	}

	private static final String [] month = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
//	���ض�Ӧ������·��ַ���
	private static String MonthString(int code) {
		return month[code - 1] ;
	}

//	���ض�Ӧ�·�������
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
