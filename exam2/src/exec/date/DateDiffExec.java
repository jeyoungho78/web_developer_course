package exec.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.time.*;

public class DateDiffExec {
	
	public static long[] getTimeDifference(Date startDate, Date endDate) throws Exception {
		if(startDate.after(endDate)) {
			throw new Exception("�������ڴ� �������ں��� Ŭ �� �����ϴ�.");
		}
		
		long[] date = new long[4];
		long diffMillSeconds = endDate.getTime() - startDate.getTime();
//	    System.out.println("diffMillSeconds : " + diffMillSeconds);
		
	    long millSecDays    = 1000 * 60 * 60 * 24;
	    long millSecHours   = 1000 * 60 * 60;
	    long millSecMinutes = 1000 * 60;
	    long millSecSeconds = 1000;
	    
	    long diffDays    = (diffMillSeconds / millSecDays);               // (��ü ms) ������ (���ڴ� ms)
	    
	    long diffMillSecHours   = (diffMillSeconds % millSecDays);        //  ���� ������ ms  ���ϱ� 
	    long diffHours = diffMillSecHours / millSecHours;                 // (���� ������ ms) ������ (�ð��� ms)
	    
	    long diffMillSecMinutes = (diffMillSecHours % millSecHours);      //  ���� ������ ms  ���ϱ� 
	    long diffMinutes = diffMillSecMinutes / millSecMinutes;           // (���� ������ ms) ������ (�д� ms)
	    
	    long diffMillSecSeconds = (diffMillSecMinutes % millSecMinutes);  //  ���� ������ ms  ���ϱ� 
	    long diffSeconds = diffMillSecSeconds / millSecSeconds;           // (���� ������ ms) ������ (�ʴ� ms)
	    
//	    System.out.println("diffDays : " + diffDays);
//	    System.out.println("diffHours : " + diffHours);
//	    System.out.println("diffMinutes : " + diffMinutes);
//	    System.out.println("diffSeconds : " + diffSeconds);
	
	    date[0] = diffDays;
	    date[1] = diffHours;
	    date[2] = diffMinutes;
	    date[3] = diffSeconds;
		
		return date;
	}

	public static void main(String[] args) {
		Random rd = new Random();
		
		int year = rd.nextInt(17) + 2000;
		int month = rd.nextInt(12);
		int date = rd.nextInt(31) + 1;
		int hourOfDay = rd.nextInt(24) + 1;
		int minute = rd.nextInt(60) + 1;
		int second = rd.nextInt(60) + 1;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
		
		GregorianCalendar startGcal = new GregorianCalendar(year, month, date, hourOfDay, minute, second);
		Date startDate = startGcal.getTime();
		System.out.println("�������� : " + sdf.format(startDate));
		
		GregorianCalendar endGcal = new GregorianCalendar(2017, 3-1, 12);
		Date endDate = endGcal.getTime();
		System.out.println("�������� : " + sdf.format(endDate));
		
		try {
			long[] diffDate = getTimeDifference(startDate, endDate);
			
			System.out.println("diffDays    : " + diffDate[0]);
		    System.out.println("diffHours   : " + diffDate[1]);
		    System.out.println("diffMinutes : " + diffDate[2]);
		    System.out.println("diffSeconds : " + diffDate[3]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		/*
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		GregorianCalendar startGcal = new GregorianCalendar(2016, 3-1,  10, 13, 11, 52);
		Date startDate = startGcal.getTime();
		System.out.println("�������� : " + sdf.format(startDate));
		
		GregorianCalendar endGcal = new GregorianCalendar(2017, 3-1,  12, 14, 13, 46);
		Date endDate = endGcal.getTime();
		System.out.println("�������� : " + sdf.format(endDate));
		
		long diffMillSeconds = endDate.getTime() - startDate.getTime();
	    System.out.println("diffMillSeconds : " + diffMillSeconds);
		
	    long millSecDays = 1000 * 60 * 60 * 24;
	    long millSecHours = 1000 * 60 * 60;
	    long millSecMinutes = 1000 * 60;
	    long millSecSeconds = 1000;
	    
	    long diffDays    = (diffMillSeconds / millSecDays);
	    
	    long diffMillSecHours   = (diffMillSeconds % millSecDays);
	    long diffHours = diffMillSecHours / millSecHours;
	    
	    long diffMillSecMinutes = (diffMillSecHours % millSecHours);
	    long diffMinutes = diffMillSecMinutes / millSecMinutes;
	    
	    long diffMillSecSeconds = (diffMillSecMinutes % millSecMinutes);
	    long diffSeconds = diffMillSecSeconds / millSecSeconds;
	    
	    System.out.println("diffDays : " + diffDays);
	    System.out.println("diffHours : " + diffHours);
	    System.out.println("diffMinutes : " + diffMinutes);
	    System.out.println("diffSeconds : " + diffSeconds);
	    */
	}
	
}
