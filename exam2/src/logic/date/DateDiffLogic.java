package logic.date;

import java.util.Date;

public class DateDiffLogic {

	public static long[] getTimeDifference(Date startDate, Date endDate) throws Exception {
		if(startDate.after(endDate)) {
			throw new Exception("시작일자는 종료일자보다 클 수 없습니다.");
		}
		
		long[] date = new long[4];
		long diffMillSeconds = endDate.getTime() - startDate.getTime();
		
	    long millSecDays    = 1000 * 60 * 60 * 24;
	    long millSecHours   = 1000 * 60 * 60;
	    long millSecMinutes = 1000 * 60;
	    long millSecSeconds = 1000;
	    
	    long diffDays    = (diffMillSeconds / millSecDays);               // (전체 ms) 나누기 (일자당 ms)
	    
	    long diffMillSecHours   = (diffMillSeconds % millSecDays);        //  위의 나머지 ms  구하기 
	    long diffHours = diffMillSecHours / millSecHours;                 // (위의 나머지 ms) 나누기 (시간당 ms)
	    
	    long diffMillSecMinutes = (diffMillSecHours % millSecHours);      //  위의 나머지 ms  구하기 
	    long diffMinutes = diffMillSecMinutes / millSecMinutes;           // (위의 나머지 ms) 나누기 (분당 ms)
	    
	    long diffMillSecSeconds = (diffMillSecMinutes % millSecMinutes);  //  위의 나머지 ms  구하기 
	    long diffSeconds = diffMillSecSeconds / millSecSeconds;           // (위의 나머지 ms) 나누기 (초당 ms)
	
	    date[0] = diffDays;
	    date[1] = diffHours;
	    date[2] = diffMinutes;
	    date[3] = diffSeconds;
		
		return date;
	}
	
}
