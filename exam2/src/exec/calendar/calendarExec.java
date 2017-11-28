package exec.calendar;

import java.util.Calendar;
import java.util.Random;

public class calendarExec {

	public static void printCalendar(int year, int month) {
		int firstDayOfWeek = 0; // 해당월의 첫날요일
		int firstDay = 0;       // 해당월의 첫날일
		int lastDay = 0;        // 해당월의 마지막일
		int curDay = -1;        // 현재날짜
		int curDayOfWeek = -1;  // 현재날짜의 주
		String[] strHeaderWeek = {"일","월","화","수","목","금","토"};
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, 1); // 일까지 설정해줘야 정상적으로 출력 (해당월의 1일로 설정)
		
		firstDay = calendar.getActualMinimum(Calendar.DATE);
		lastDay = calendar.getActualMaximum(Calendar.DATE);

		// 해당월의 첫날요일
		firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		// 년,월 출력
		System.out.println(year + "년 " + month + "월");
		System.out.println();
		
		// 달력헤더 출력
		for(int i=0; i<strHeaderWeek.length; i++) {
			System.out.printf("%2s ", strHeaderWeek[i]);
		}
		System.out.println();
		
		// 달력본체 출력
		curDayOfWeek = firstDayOfWeek;
		for (curDay = firstDay; curDay <= lastDay; curDay++) {
			if (curDay == firstDay) { // 현재날짜가 해당월의 첫날일과 같을 경우 처리
				for (int i = 1; i < curDayOfWeek; i++) {
					System.out.print("   ");
				} 
			}
			
			System.out.printf("%2d ", curDay);
		
			if (curDayOfWeek % 7 == 0) {
				System.out.println();
			}
			curDayOfWeek++;
		}
		
	}//printCalenar
	
	public static void main(String[] args) {
		Random rd = new Random();
		int year = rd.nextInt(20) + 2010;
		int month = rd.nextInt(12) + 1;
		
		try {
			if(year%2 == 0) {
				printCalendar(year, month);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println(year + "년, 해당월을 출력할 수 없습니다.");
		}
		

	}// main
}// class
