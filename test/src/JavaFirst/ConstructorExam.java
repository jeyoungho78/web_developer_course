package JavaFirst;

public class ConstructorExam {

	int a;
	public ConstructorExam( ) {
		a = 10;
	}
	
	/*public void ConstructorExam( ) {
		a = 10;
	}*/ // �����ڰ� �ƴ϶� ���ϰ��� ���� ��� �Լ�
	
	public ConstructorExam(int a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		ConstructorExam ob1 = new ConstructorExam();
		ConstructorExam ob2 = new ConstructorExam(20);
		ConstructorExam ob3 = new ConstructorExam(30);
		
		System.out.println(ob1.a);
		System.out.println(ob2.a);
		System.out.println(ob3.a);
	}
}
