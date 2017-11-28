package exec.calendar;

import java.util.Calendar;
import java.util.Random;

public class calendarExec {

	public static void printCalendar(int year, int month) {
		int firstDayOfWeek = 0; // �ش���� ù������
		int firstDay = 0;       // �ش���� ù����
		int lastDay = 0;        // �ش���� ��������
		int curDay = -1;        // ���糯¥
		int curDayOfWeek = -1;  // ���糯¥�� ��
		String[] strHeaderWeek = {"��","��","ȭ","��","��","��","��"};
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, 1); // �ϱ��� ��������� ���������� ��� (�ش���� 1�Ϸ� ����)
		
		firstDay = calendar.getActualMinimum(Calendar.DATE);
		lastDay = calendar.getActualMaximum(Calendar.DATE);

		// �ش���� ù������
		firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		// ��,�� ���
		System.out.println(year + "�� " + month + "��");
		System.out.println();
		
		// �޷���� ���
		for(int i=0; i<strHeaderWeek.length; i++) {
			System.out.printf("%2s ", strHeaderWeek[i]);
		}
		System.out.println();
		
		// �޷º�ü ���
		curDayOfWeek = firstDayOfWeek;
		for (curDay = firstDay; curDay <= lastDay; curDay++) {
			if (curDay == firstDay) { // ���糯¥�� �ش���� ù���ϰ� ���� ��� ó��
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
			System.out.println(year + "��, �ش���� ����� �� �����ϴ�.");
		}
		

	}// main
}// class
