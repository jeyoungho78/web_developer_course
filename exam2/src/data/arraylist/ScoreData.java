package data.arraylist;

public class ScoreData {
	
	String name;
	
	int kor;
	int eng;
	int math;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public String toString() {
		return "( ���� : " + this.kor + " ���� : " + this.eng + " ���� : " + this.math + " )";
	}
	
	

}
