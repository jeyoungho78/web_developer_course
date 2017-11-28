package JavaFirst;

public class ThisConstructorExam {

	public ThisConstructorExam() {
		System.out.println("¾È³ç~~");
	}
	
	public ThisConstructorExam(String s) {
		this();
		System.out.println(s);
	}
	
	public ThisConstructorExam(int a) {
		this("¹Ý°¡¿ö~~");
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		ThisConstructorExam ob = new ThisConstructorExam(20);
	}
	
}
