package logic.date;

import java.util.Date;

public class DateDiffLogic {

	public static long[] getTimeDifference(Date startDate, Date endDate) throws Exception {
		if(startDate.after(endDate)) {
			throw new Exception("�������ڴ� �������ں��� Ŭ �� �����ϴ�.");
		}
		
		long[] date = new long[4];
		long diffMillSeconds = endDate.getTime() - startDate.getTime();
		
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
	
	    date[0] = diffDays;
	    date[1] = diffHours;
	    date[2] = diffMinutes;
	    date[3] = diffSeconds;
		
		return date;
	}
	
}
