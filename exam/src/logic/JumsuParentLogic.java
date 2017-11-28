package logic;

import data.JumsuData;

public class JumsuParentLogic {

	JumsuData jd;
	
	int[] korSet;
	int[] engSet;
	int[] mathSet;
	
	JumsuParentLogic(int[] a, int[] b, int[] c) {
		jd = new JumsuData();
		
		korSet = new int[]{a[0], b[0], c[0]};
		engSet = new int[]{a[1], b[1], c[1]};
		mathSet = new int[]{a[2], b[2], c[2]};	
	}
	
	public void calcTotalSum() {
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		
		for(int i=0; i<korSet.length; i++) {
			korSum = korSum + korSet[i];
		}
		jd.setKorSum(korSum);
		
		for(int i=0; i<engSet.length; i++) {
			engSum = engSum + engSet[i];
		}
		jd.setEngSum(engSum);
		
		for(int i=0; i<mathSet.length; i++) {
			mathSum = mathSum + mathSet[i];
		}
		jd.setMathSum(mathSum);
		
		System.out.println("국어 합계 : " + jd.getKorSum());
		System.out.println("영어 합계 : " + jd.getEngSum());
		System.out.println("수학 합계 : " + jd.getMathSum());
	}
	
}
