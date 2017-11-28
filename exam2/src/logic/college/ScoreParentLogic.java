package logic.college;

import data.college.ScoreData;

public class ScoreParentLogic {
	
	ScoreData sd;
	
	public ScoreParentLogic(ScoreData sd) {
		this.sd = sd;
	}
	
	public int calcKorSum() {
		int sum = 0;
		
		for(int i=0; i<sd.getKorSet().length; i++) {
			sum = sum + sd.getKorSet()[i];
		}
		return sum;
	}//calcKorSum
	
	public int calcEngSum() {
		int sum = 0;
		
		for(int i=0; i<sd.getEngSet().length; i++) {
			sum = sum + sd.getEngSet()[i];
		}
		return sum;
	}//calcEngSum
	
	public int calcMathSum() {
		int sum = 0;
		
		for(int i=0; i<sd.getMathSet().length; i++) {
			sum = sum + sd.getMathSet()[i];
		}
		return sum;
	}//calcMathSum
}//class
