package JavaFirst;

public class InstanceBlockExam {

	int a;
	
	{ // �ν��Ͻ� ��� ����
		System.out.println("�ν��Ͻ� ���");
		a = 10;
	} // �ν��Ͻ� ��� ��
	
	public InstanceBlockExam(int a) {
		System.out.println("������");
		this.a = a;
	}
	
	public static void main(String[] args) {
		InstanceBlockExam ob = new InstanceBlockExam(30);
		System.out.println(ob.a);
	}
	
}
