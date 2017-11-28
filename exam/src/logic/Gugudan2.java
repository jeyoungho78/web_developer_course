package logic;

public class Gugudan2 {
	int a;
	int b;
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public void multi(int a) {
		for(int i=1; i<=9; i++) {
			System.out.println(a + " x " + i + " = " + (a*i));
		}
	}
	
	public void multi(int a, int b) {
		for(int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %2d", a, i, (a*i));
			System.out.print("\t");
			System.out.printf("%d x %d = %2d", b, i, (b*i));
			System.out.println("");
		}
	}
}
