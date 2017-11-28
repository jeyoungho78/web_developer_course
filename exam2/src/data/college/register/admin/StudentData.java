package data.college.register.admin;

public class StudentData {
	String name;
	int korScore;
	int engScore;
	int mathScore;
	double totalAvg;
	int rank;
	
	StudentData[] studentArray; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public double getTotalAvg() {
		return totalAvg;
	}
	public void setTotalAvg(double totalAvg) {
		this.totalAvg = totalAvg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public StudentData[] getStudentArray() {
		return studentArray;
	}
	public void setStudentArray(StudentData[] studentArray) {
		this.studentArray = studentArray;
	}
}
