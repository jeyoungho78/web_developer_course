package exec.exception;

import java.util.Calendar;
import java.util.Random;

public class ExceptionExec {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		Random ra = new Random();
		
		int day = -1;
		int divide = -1;
		int result = -1;
		
		try {
			day = calendar.get(Calendar.DAY_OF_MONTH);
			divide = ra.nextInt(2);
			result = day / divide;
			System.out.println(day + " / " + divide + " = " + result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
}
