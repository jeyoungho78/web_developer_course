package JavaFirst;

public class ThisConstructorExam {

	public ThisConstructorExam() {
		System.out.println("�ȳ�~~");
	}
	
	public ThisConstructorExam(String s) {
		this();
		System.out.println(s);
	}
	
	public ThisConstructorExam(int a) {
		this("�ݰ���~~");
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		ThisConstructorExam ob = new ThisConstructorExam(20);
	}
	
}
