package logic.college;

import data.college.ScoreData;

public class ScoreChildLogic extends ScoreParentLogic{

	public ScoreChildLogic(ScoreData sd) {
		super(sd);
	}
	
	public double calcKorAvg() {
		double avg;
		avg = super.calcKorSum() / 3;
		return avg;
	}
	
	public double calcEngAvg() {
		double avg;
		avg = super.calcEngSum() / 3;
		return avg;
	}
	
	public double calcMathAvg() {
		double avg;
		avg = super.calcMathSum() / 3;
		return avg;
	}

}
