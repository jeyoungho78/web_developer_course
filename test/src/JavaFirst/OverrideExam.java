package JavaFirst;

import JavaCall.OverrideParent;

public class OverrideExam extends OverrideParent{
	int a = 20; // �������Ƶ�
	void f( ) {
		System.out.println(super.a); // �θ�κ��� �������� ���
		System.out.println(this.a);  // �ڽ��� �ٽ� ������ ���
		System.out.println(a); // �ڽ��� ��� 
	}
	
	public void hello() { // �������̵�
		super.hello(); // ��� ���� hello() ȣ��
		System.out.println("Son hello()"); // ��� Ȯ��
	}
	
	public static void main(String[] args) {
		OverrideExam ob = new OverrideExam();
		ob.f();
		ob.hello();
	}
}
