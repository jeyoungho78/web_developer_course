package JavaFirst;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	
	public static void main(String[] args) throws Exception {
		
		Date date = new Date();
		System.out.println("오늘날짜 : " + date.toString());
		System.out.println("날짜 : " + date.getDay());
		
		SimpleDateFormat dateforamt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		System.out.println("오늘날짜 : " + dateforamt.format(date));
		
		SimpleDateFormat dateforamt2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strdate2 = "02-04-2013 11:35:42";
		Date newdate = dateforamt2.parse(strdate2);
		System.out.println(newdate);
		
		SimpleDateFormat dateforamt3 = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateforamt3.parse("17/01/1989");
		Date date2 = dateforamt3.parse("15/10/2007");
		System.out.println("Date1 : " + dateforamt3.format(date1));
		System.out.println("Date2 : " + dateforamt3.format(date2));
		
		if(date1.after(date2)) {
			System.out.println("Date1이 Date2보다 늦다.");
		} else if (date1.before(date2)) {
			System.out.println("Date1이 Date2보다 빠르다.");
		} else if (date1.equals(date2)) {
			System.out.println("Date1이 Date2는 같다.");
		}
		
		date1 = dateforamt3.parse("27/03/2012");
		date2 = dateforamt3.parse("27/09/2009");
		System.out.println("Date1 : " + dateforamt3.format(date1));
		System.out.println("Date2 : " + dateforamt3.format(date2));
		
		if(date1.compareTo(date2) > 0) {
			System.out.println("Date1이 Date2보다 늦다.");
		} else if (date1.compareTo(date2) < 0) {
			System.out.println("Date1이 Date2보다 빠르다.");
		} else if (date1.compareTo(date2) == 0) {
			System.out.println("Date1이 Date2는 같다.");
		}
		
	}

}
