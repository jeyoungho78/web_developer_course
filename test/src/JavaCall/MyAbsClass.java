package JavaCall;

public abstract class MyAbsClass {
	// �߻� �޼ҵ带 �����ϴ� Ŭ����
	// ��ü�� ������ �� ����
	// abstract �޼ҵ�� private �Ǵ� static�� �� �� ����
	// (static �޼ҵ�� ��ü ���̵� ȣ��Ǵ� �޼ҵ��̹Ƿ� body�� ���ǵǾ�� �Ѵ�.)
	
	int myInt;
	public abstract void noAction(); // �߻� �޼ҵ�
	
	public int getMyInt() {          // �� �߻� �޼ҵ� 
		return myInt;
	}
	
}
