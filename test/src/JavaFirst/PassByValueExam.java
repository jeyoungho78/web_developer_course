package JavaFirst;

public class PassByValueExam {
	
	static void method(int a) {
		a = 20;
	}
	
	public static void main(String[] args) {
		int x = 10;
		method(x);
		System.out.println(x);
	}
}
