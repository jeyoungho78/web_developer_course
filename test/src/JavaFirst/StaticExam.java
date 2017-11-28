package JavaFirst;

public class StaticExam {

	static int a;
	int b;
	
	static int return123() {
		return 123;
	}
	
	public static void main(String[] args) {
		
		StaticExam.a = 10; // x1
		StaticExam ob1 = new StaticExam();
		StaticExam ob2 = new StaticExam();
		
		System.out.println(ob1.a);
		ob1.a = 20;
		System.out.println(ob2.a);
		
		ob2.a = 30;
		System.out.println(StaticExam.a);
		
		// System.out.println(StaticExam.b); // non-static ������ ��ü�� ���� ��밡��
		
		System.out.println(ob1.return123()); // Static method�� ��ü�� �����ؼ��� ��밡��
		System.out.println(StaticExam.return123()); // Static method�� ��ü ���� ���̵� ��밡��
	}
	
	
}
