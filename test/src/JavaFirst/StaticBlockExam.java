package JavaFirst;

public class StaticBlockExam {
	static int b;
	
	static {
		System.out.println("Static Block Call!");
		b = 30; // static ����� �� �� �ִ�.
	}
	
	public static void main(String[] args) {
		System.out.println("Main Block Start");
		System.out.println(b);
	}
}
