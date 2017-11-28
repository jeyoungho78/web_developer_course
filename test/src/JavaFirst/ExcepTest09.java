package JavaFirst;

class ExcepTest09Logic {
	
	public void errProcess() {
		try {
			errMake();
		} catch (Exception e) {
			System.out.println("������ ó���մϴ�.");
			System.out.println(e.getMessage());
			System.out.println("��������:");
			e.printStackTrace();
		}
	}

	public void errMake() throws Exception {
		System.out.println("������ �߻���ŵ�ϴ�.");
		throw new Exception("errMake() �Լ����� ������ �߻��Ͽ����ϴ�.");
	}
	
}

public class ExcepTest09 {
	
	public static void main(String[] args) {
		ExcepTest09Logic exLogic = new ExcepTest09Logic();
		exLogic.errProcess();
	}
	
}
