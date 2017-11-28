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

		System.out.println("국어 최고 점수 : ");
		System.out.println("\t" + "이름 : " + sdArr[studentMaxIndex].getName());
		System.out.println("\t" + "점수 : " + max);
		
		studentMaxIndex = 0;
		max = 0;
		
		for (int i = 0; i < sdArr.length; i++) {
			if (sdArr[i].getEngScore() > max) {
				max = sdArr[i].getEngScore();
				studentMaxIndex = i;
			}

		}

		System.out.println("영어 최고 점수 : ");
		System.out.println("\t" + "이름 : " + sdArr[studentMaxIndex].getName());
		System.out.println("\t" + "점수 : " + max);
		
		studentMaxIndex = 0;
		max = 0;
		
		for (int i = 0; i < sdArr.length; i++) {
			if (sdArr[i].getMathScore() > max) {
				max = sdArr[i].getMathScore();
				studentMaxIndex = i;
			}

		}

		System.out.println("영어 최고 점수 : ");
		System.out.println("\t" + "이름 : " + sdArr[studentMaxIndex].getName());
		System.out.println("\t" + "점수 : " + max);

	}// printBestScore

	public void printGrade() {
		StudentData[] sdArr = sd.getStudentArray();
		double[] avgArr = new double[sdArr.length];
		int[] studentIndexArr = new int[sdArr.length];
		double avg = 0.0;
		
		// 평균 셋팅
		for (int i = 0; i < sdArr.length; i++) {
			avg = (double)(sdArr[i].getKorScore() + sdArr[i].getEngScore() + sdArr[i].getMathScore()) / 3;
			sdArr[i].setTotalAvg(avg);
			
			avgArr[i] = avg;
			studentIndexArr[i] = i;
		}
		
		int studentIndexArrTmp = 0;
		double avgTmp = 0.0;
		
		// 평균 정렬
		for (int i = 0; i < avgArr.length; i++) {
			for(int j = 0; j < avgArr.length - i - 1; j++) {
				if(avgArr[j] < avgArr[j+1]) {
					// 평균
					avgTmp = avgArr[j+1];
					avgArr[j+1] = avgArr[j];
					avgArr[j] = avgTmp;
					
					// 학생 배열 인덱스 
					studentIndexArrTmp = studentIndexArr[j+1];
					studentIndexArr[j+1] = studentIndexArr[j];
					studentIndexArr[j] = studentIndexArrTmp;
				}
				
			}
		}
		
		System.out.println("-------------------------------------------------------");
		
		int rank = 0;
		int rankIndex = 0;
		
		// 랭킹 셋팅
		for (int i = 0; i < studentIndexArr.length; i++) {
			rank = rank + 1;
			rankIndex = studentIndexArr[i];
			sdArr[rankIndex].setRank(rank);
			
			System.out.println("순위 : " + sdArr[rankIndex].getRank());
			System.out.println("\t" + "이름 : " + sdArr[rankIndex].getName());
			System.out.println("\t" + "평균 : " + sdArr[rankIndex].getTotalAvg());
		}
		
			
	}// printGrade
}
