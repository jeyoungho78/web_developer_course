package logic.date;

import java.util.Date;
import logic.date.DateDiffLogic;
import data.date.ChargeParkingFeeData;

public class ChargeParkingFeeLogic {

	public int getFee(ChargeParkingFeeData data) {
		Date startDate = data.getStartDate();
		Date endDate = data.getEndDate();
		int fee = -9999;

		try {
			DateDiffLogic ddl = new DateDiffLogic();
			long[] diffDate = ddl.getTimeDifference(startDate, endDate);

			long diffDays = diffDate[0];
			long diffHours = diffDate[1];
			long diffMinutes = diffDate[2];
			long diffSeconds = diffDate[3];
			 
			if(diffDays >= 1) {                                                // 1일 이상
				if(diffHours >= 14) {                                          // 1일 이상이면서 14시간 이상일 경우
					fee = ((int)diffDays + 1) * 10000;
				} else {
					fee = (int)diffDays * 10000;
				}
			} else if (diffHours >= 14) {                						// 14시간 이상일 경우 1일 요금
				fee = 10000;
			} else {
				long duringMinutes = (diffHours * 60) + diffMinutes;            // 1일 미만 시간당 요금
				int countPerTenMinutes = (int)duringMinutes / 10;
				fee = countPerTenMinutes * 500;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return fee;
	}

}
