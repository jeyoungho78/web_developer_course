package JavaFirst;

public class ConstructorExamError {
	
	int a;

	public ConstructorExamError( ) {
		System.out.println("���ڰ� ���� ����Ʈ ������");
	} // ConstructorExamError
	
	public ConstructorExamError(int a) {
		// this();
		this.a = a;
		// this(); // ������.... ������ ������ ��ߵ�. 
	}
	
	public static void main(String[] args) {
		ConstructorExamError ob = new ConstructorExamError(2); // �ٸ� �����ڰ� ������ �⺻ �����ڰ� ���� �ȵ�
//		�����ڸ� �ڵ����� ��������� �ʴ´�.
//		���� ����� �־�� �Ѵ�.
	    //System.out.println(ob.a);
	}
	
}
