package exec.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import data.date.ChargeParkingFeeData;
import logic.date.ChargeParkingFeeLogic;

public class ChargeParkingFeeExec {
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		GregorianCalendar startGcal = new GregorianCalendar(2017, 3-1, 11, 01, 10, 52);
		Date startDate = startGcal.getTime();
		System.out.println("시작일자 : " + sdf.format(startDate));
		
		GregorianCalendar endGcal   = new GregorianCalendar(2017, 3-1, 12, 12, 10, 52);
		Date endDate = endGcal.getTime();
		System.out.println("종료일자 : " + sdf.format(endDate));
		
		ChargeParkingFeeData cpfData = new ChargeParkingFeeData();
		cpfData.setStartDate(startDate);
		cpfData.setEndDate(endDate);
		
		ChargeParkingFeeLogic cpfLogic = new ChargeParkingFeeLogic();
		int fee = cpfLogic.getFee(cpfData);
		
		System.out.println("주차요금 : " + fee + "원");
	}

}
