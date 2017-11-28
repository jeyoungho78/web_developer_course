package JavaFirst;

// 난 중요기능만 여기 클래스에서 처리할 거다.....
class JavaLogic {
	int a; // 변수
	
	int sum(int a, int b) { // 메서드
		return (a + b);
	}
}

// 이클래스는 데이터만 담겠어 ....
class JavaData {
	
	int b;
	int c;
	int d;
	int e;
	
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
}