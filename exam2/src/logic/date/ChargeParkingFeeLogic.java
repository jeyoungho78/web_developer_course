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
			 
			if(diffDays >= 1) {                                                // 1�� �̻�
				if(diffHours >= 14) {                                          // 1�� �̻��̸鼭 14�ð� �̻��� ���
					fee = ((int)diffDays + 1) * 10000;
				} else {
					fee = (int)diffDays * 10000;
				}
			} else if (diffHours >= 14) {                						// 14�ð� �̻��� ��� 1�� ���
				fee = 10000;
			} else {
				long duringMinutes = (diffHours * 60) + diffMinutes;            // 1�� �̸� �ð��� ���
				int countPerTenMinutes = (int)duringMinutes / 10;
				fee = countPerTenMinutes * 500;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return fee;
	}

}
