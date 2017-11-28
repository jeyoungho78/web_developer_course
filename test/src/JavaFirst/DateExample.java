package JavaFirst;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	
	public static void main(String[] args) throws Exception {
		
		Date date = new Date();
		System.out.println("���ó�¥ : " + date.toString());
		System.out.println("��¥ : " + date.getDay());
		
		SimpleDateFormat dateforamt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		System.out.println("���ó�¥ : " + dateforamt.format(date));
		
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
			System.out.println("Date1�� Date2���� �ʴ�.");
		} else if (date1.before(date2)) {
			System.out.println("Date1�� Date2���� ������.");
		} else if (date1.equals(date2)) {
			System.out.println("Date1�� Date2�� ����.");
		}
		
		date1 = dateforamt3.parse("27/03/2012");
		date2 = dateforamt3.parse("27/09/2009");
		System.out.println("Date1 : " + dateforamt3.format(date1));
		System.out.println("Date2 : " + dateforamt3.format(date2));
		
		if(date1.compareTo(date2) > 0) {
			System.out.println("Date1�� Date2���� �ʴ�.");
		} else if (date1.compareTo(date2) < 0) {
			System.out.println("Date1�� Date2���� ������.");
		} else if (date1.compareTo(date2) == 0) {
			System.out.println("Date1�� Date2�� ����.");
		}
		
	}

}
