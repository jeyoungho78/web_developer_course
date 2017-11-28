package logic.college.register.admin;

import data.college.register.admin.StudentData;

public class CollegeRegisterAdminLogic {

	StudentData sd;

	public CollegeRegisterAdminLogic(StudentData sd) {
		this.sd = sd;
	}

	public void printBestScore() {
		StudentData[] sdArr = sd.getStudentArray();
		int studentMaxIndex = 0; 
		int max = 0;

		for (int i = 0; i < sdArr.length; i++) {
			if (sdArr[i].getKorScore() > max) {
				max = sdArr[i].getKorScore();
				studentMaxIndex = i;
			}

		}

		System.out.println("���� �ְ� ���� : ");
		System.out.println("\t" + "�̸� : " + sdArr[studentMaxIndex].getName());
		System.out.println("\t" + "���� : " + max);
		
		studentMaxIndex = 0;
		max = 0;
		
		for (int i = 0; i < sdArr.length; i++) {
			if (sdArr[i].getEngScore() > max) {
				max = sdArr[i].getEngScore();
				studentMaxIndex = i;
			}

		}

		System.out.println("���� �ְ� ���� : ");
		System.out.println("\t" + "�̸� : " + sdArr[studentMaxIndex].getName());
		System.out.println("\t" + "���� : " + max);
		
		studentMaxIndex = 0;
		max = 0;
		
		for (int i = 0; i < sdArr.length; i++) {
			if (sdArr[i].getMathScore() > max) {
				max = sdArr[i].getMathScore();
				studentMaxIndex = i;
			}

		}

		System.out.println("���� �ְ� ���� : ");
		System.out.println("\t" + "�̸� : " + sdArr[studentMaxIndex].getName());
		System.out.println("\t" + "���� : " + max);

	}// printBestScore

	public void printGrade() {
		StudentData[] sdArr = sd.getStudentArray();
		double[] avgArr = new double[sdArr.length];
		int[] studentIndexArr = new int[sdArr.length];
		double avg = 0.0;
		
		// ��� ����
		for (int i = 0; i < sdArr.length; i++) {
			avg = (double)(sdArr[i].getKorScore() + sdArr[i].getEngScore() + sdArr[i].getMathScore()) / 3;
			sdArr[i].setTotalAvg(avg);
			
			avgArr[i] = avg;
			studentIndexArr[i] = i;
		}
		
		int studentIndexArrTmp = 0;
		double avgTmp = 0.0;
		
		// ��� ����
		for (int i = 0; i < avgArr.length; i++) {
			for(int j = 0; j < avgArr.length - i - 1; j++) {
				if(avgArr[j] < avgArr[j+1]) {
					// ���
					avgTmp = avgArr[j+1];
					avgArr[j+1] = avgArr[j];
					avgArr[j] = avgTmp;
					
					// �л� �迭 �ε��� 
					studentIndexArrTmp = studentIndexArr[j+1];
					studentIndexArr[j+1] = studentIndexArr[j];
					studentIndexArr[j] = studentIndexArrTmp;
				}
				
			}
		}
		
		System.out.println("-------------------------------------------------------");
		
		int rank = 0;
		int rankIndex = 0;
		
		// ��ŷ ����
		for (int i = 0; i < studentIndexArr.length; i++) {
			rank = rank + 1;
			rankIndex = studentIndexArr[i];
			sdArr[rankIndex].setRank(rank);
			
			System.out.println("���� : " + sdArr[rankIndex].getRank());
			System.out.println("\t" + "�̸� : " + sdArr[rankIndex].getName());
			System.out.println("\t" + "��� : " + sdArr[rankIndex].getTotalAvg());
		}
		
			
	}// printGrade
}
