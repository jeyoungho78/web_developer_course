package JavaFirst;

import JavaCall.Sub;
import JavaCall.Super;

public class ReferenceScope {
	
	public static void main(String[] args) {
		Super ob = new Sub();
		// �θ�Ŭ���� ����  = �ڽ�Ŭ��������
		
		ob.a = 20;
		ob.hi(); // �ڽ��� hi()�� ����ȴ�.
		//ob.b = 30; // -> ����, �����Ұ�
		//ob.bye();  // -> ����, �����Ұ�
	
	}
	
}
