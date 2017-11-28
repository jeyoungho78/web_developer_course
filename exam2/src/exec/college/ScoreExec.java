package exec.college;

import data.college.ScoreData;
import logic.college.ScoreChildLogic;

public class ScoreExec {

	public static void main(String[] args) {
		
		// �л�����
		int[] a = {10, 20 ,30};
		int[] b = {40, 50 ,60};
		int[] c = {70, 80 ,90};
		
		// ��,��,���� ������ �迭�� �з�
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
        
		// ���� Ŭ������ ������ ���� (������ �����)
		ScoreData sd = new ScoreData();
		
		sd.setKorSet(korSet);
		sd.setEngSet(engSet);
		sd.setMathSet(mathSet);
		
		// �ڽ� Ŭ������ ���� ����
		ScoreChildLogic scl = new ScoreChildLogic(sd);
		
		sd.setKorSum(scl.calcKorSum());
		sd.setEngSum(scl.calcEngSum());
		sd.setMathSum(scl.calcMathSum());
		System.out.println("�����հ� : " + sd.getKorSum());
		System.out.println("�����հ� : " + sd.getEngSum());
		System.out.println("�����հ� : " + sd.getMathSum());
		
		sd.setKorAvg(scl.calcKorAvg());
		sd.setEngAvg(scl.calcEngAvg());
		sd.setMathAvg(scl.calcMathAvg());
		System.out.println("������� : " + sd.getKorAvg());
		System.out.println("������� : " + sd.getEngAvg());
		System.out.println("������� : " + sd.getMathAvg());
		
	}
	
}
