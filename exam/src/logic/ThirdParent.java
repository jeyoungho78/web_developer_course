package logic;

public class ThirdParent {

	protected int a;
	
	ThirdParent() {
		a = 1;
	}
	
	//protected: package�� �����ҽÿ��� ��ӽ� �ڽ�Ŭ�������� ���ٰ����� ����������
	protected ThirdParent(int a){
		this.a = a;
	}
	
}
