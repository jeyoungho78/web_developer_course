package JavaFirst;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarFunctionExample {

	/*
	  private static String getTimeFormat(String time, String format) throws
	  Exception{ String strdate = "";
	  
	  SimpleDateFormat sdf = new SimpleDateFormat(format); Calendar calendar =
	  Calendar.getInstance();
	  
	  if(time == "") { strdate = sdf.format(calendar.getTime()); } else { Date date
	  = sdf.parse(time); calendar.setTime(date); strdate =
	  sdf.format(calendar.getTime()); }
	  
	  return strdate; }
	 */
	
/*	
 	private static String getTimeFormat(String time, String format) throws Exception {
		String strdate = "";

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();

		if (time.equals("")) {
			strdate = sdf.format(calendar.getTime());
		} else if (time.length() == 14){
			int year = Integer.valueOf(time.substring(0, 4));
			int month = Integer.valueOf(time.substring(4, 6));
			int date = Integer.valueOf(time.substring(6, 8));
			int hourOfDay = Integer.valueOf(time.substring(8, 10));
			int minute = Integer.valueOf(time.substring(10, 12));
			int second = Integer.valueOf(time.substring(12, 14));

			calendar.set(year, month - 1, date, hourOfDay, minute, second); // month는 0부터 시작 
			strdate = sdf.format(calendar.getTime());
		}

		return strdate;
	}
	*/
	
	private static String getTimeFormat(String time, String format) throws Exception {
		String strdate = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		if (time.equals("")) {
			Calendar calendar = Calendar.getInstance();
			strdate = sdf.format(calendar.getTime());
		} else if (time.length() == 14){
			int year = Integer.valueOf(time.substring(0, 4));
			int month = Integer.valueOf(time.substring(4, 6));
			int date = Integer.valueOf(time.substring(6, 8));
			int hourOfDay = Integer.valueOf(time.substring(8, 10));
			int minute = Integer.valueOf(time.substring(10, 12));
			int second = Integer.valueOf(time.substring(12, 14));

			//calendar.set(year, month - 1, date, hourOfDay, minute, second); // month는 0부터 시작 
			GregorianCalendar calendar = new GregorianCalendar(year, month - 1, date, hourOfDay, minute, second);
			strdate = sdf.format(calendar.getTime());
		}

		return strdate;
	}

	public static void main(String[] args) throws Exception {

		String strdate = "";

		strdate = getTimeFormat("", "hh:ss");
		System.out.println(strdate);

		strdate = getTimeFormat("", "yyyy MMM dd HH:mm:ss");
		System.out.println(strdate);

		strdate = getTimeFormat("", "dd/MM/yyyy hh:mm:ss");
		System.out.println(strdate);

		strdate = getTimeFormat("", "dd-M-yyyy hh:mm:ss");
		System.out.println(strdate);

		System.out.println("======================================");

		strdate = getTimeFormat("20170919112625", "hh:ss");
		System.out.println(strdate);

		strdate = getTimeFormat("20170919112625", "yyyy MMM dd HH:mm:ss");
		System.out.println(strdate);

		strdate = getTimeFormat("20170919112625", "dd/MM/yyyy hh:mm:ss");
		System.out.println(strdate);

		strdate = getTimeFormat("20170919112625", "dd-M-yyyy hh:mm:ss");
		System.out.println(strdate);

	}

}
