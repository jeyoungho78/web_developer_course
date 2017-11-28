package logic;

public class Gugudan {

	// 멤버변수
	int a;
	
	
	
	
	// get, set
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	
	
	// 메서드
	public void printGugudan() {
		for(int i=1; i<=9; i++) {
			System.out.println(a + " x " + i + " = " + (a*i));
		}
	}
	
	
}//class
