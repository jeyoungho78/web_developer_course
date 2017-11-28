package exec.college;

import data.college.ScoreData;
import logic.college.ScoreChildLogic;

public class ScoreExec {

	public static void main(String[] args) {
		
		// 학생점수
		int[] a = {10, 20 ,30};
		int[] b = {40, 50 ,60};
		int[] c = {70, 80 ,90};
		
		// 국,영,수로 나누어 배열로 분류
		int[] korSet = new int[3];
		int[] engSet = new int[3];
		int[] mathSet = new int[3];
		
		korSet[0] = a[0];
		korSet[1] = b[0];
		korSet[2] = c[0];

		engSet[0] = a[1];
		engSet[1] = b[1];
		engSet[2] = c[1];

		mathSet[0] = a[2];
		mathSet[1] = b[2];
		mathSet[2] = c[2];
        
		// 점수 클래스에 데이터 셋팅 (데이터 입출력)
		ScoreData sd = new ScoreData();
		
		sd.setKorSet(korSet);
		sd.setEngSet(engSet);
		sd.setMathSet(mathSet);
		
		// 자식 클래스로 연산 실행
		ScoreChildLogic scl = new ScoreChildLogic(sd);
		
		sd.setKorSum(scl.calcKorSum());
		sd.setEngSum(scl.calcEngSum());
		sd.setMathSum(scl.calcMathSum());
		System.out.println("국어합계 : " + sd.getKorSum());
		System.out.println("영어합계 : " + sd.getEngSum());
		System.out.println("수학합계 : " + sd.getMathSum());
		
		sd.setKorAvg(scl.calcKorAvg());
		sd.setEngAvg(scl.calcEngAvg());
		sd.setMathAvg(scl.calcMathAvg());
		System.out.println("국어평균 : " + sd.getKorAvg());
		System.out.println("영어평균 : " + sd.getEngAvg());
		System.out.println("수학평균 : " + sd.getMathAvg());
		
	}
	
}
