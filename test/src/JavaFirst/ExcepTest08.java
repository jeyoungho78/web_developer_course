package JavaFirst;

public class ExcepTest08 {
	
	public static void main(String[] args) {
		try {
			int a = 1;
			int b = 0;
			
			if(b== 0) {
				//Exception x = new Exception();
				// throw x;
				throw new Exception();
			}
			System.out.println("a*b : " + (a*b));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�Էµ� ���ڴ� 0�� �� �� �����ϴ�.");
		}
	}
	
}
