package JavaFirst;

public class ExcepTest3 {

	public static void main(String[] args) {
		int a = 10, b01 = 0, b02 = 2, c = 10;
		System.out.println("try ���� �����ϱ� �� c ----> " +  c);
		
		try {
			System.out.println("try �������� ����");
			System.out.println("������ �����ϱ� �� try ����");
			
			c = a / b02;
			System.out.println(" (1) c -> " + c);
			
			c = a / b01;
			System.out.println(" (2) c -> " + c);
			
			c = a / b02;
			System.out.println(" (3) c -> " + c);
			
		} catch(ArithmeticException e) {
			System.out.println("���ܰ� �����Ͽ� ArithmeticException ��ü�� ���� ->" + e);
		} catch(Exception e) {
			System.out.println("���ܰ� �����Ͽ� Exception ��ü�� ���� ->" + e);
		} finally {
			System.out.println("try/catch ������ ���� ���� �۾� c-->" + c);
		}
		
		System.out.println("try ������ ������ �� c-->" + c);
		
	}
	
}
