package JavaFirst;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarExample {
	
	public static void main(String[] args){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance(); 
		
		//calendar.add(Calendar.DAY_OF_MONTH, 1);
		
		int year     	= calendar.get(Calendar.YEAR);
		int month 		= calendar.get(Calendar.MONTH); // Jan = 0, 
		int dayOfMonth 	= calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek 	= calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear 	= calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
		
		int hour 		= calendar.get(Calendar.HOUR);
		int hourOfDay 	= calendar.get(Calendar.HOUR_OF_DAY);
		int minute 		= calendar.get(Calendar.MINUTE);
		int second 		= calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		
		System.out.println(sdf.format(calendar.getTime()));
		
		System.out.println("year     	 \t\t : " + year     	);
		System.out.println("month 		 \t\t : " + month 		);
		System.out.println("dayOfMonth   \t\t : " + dayOfMonth  );
		System.out.println("dayOfWeek 	 \t\t : " + dayOfWeek 	);
		System.out.println("weekOfYear   \t\t : " + weekOfYear  );
		System.out.println("weekOfMonth  \t\t : " + weekOfMonth);
		                                                       
		System.out.println("hour 		 \t\t : " + hour 		);
		System.out.println("hourOfDay 	 \t\t : " + hourOfDay 	);
		System.out.println("minute 		 \t\t : " + minute 		);
		System.out.println("second 		 \t\t : " + second 		);
		System.out.println("millisecond  \t\t : " + millisecond );
		
		
	}

}
