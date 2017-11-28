package JavaFirst;

public class ExcepTest3 {

	public static void main(String[] args) {
		int a = 10, b01 = 0, b02 = 2, c = 10;
		System.out.println("try 구문 수행하기 전 c ----> " +  c);
		
		try {
			System.out.println("try 구문으로 들어옴");
			System.out.println("나누기 연산하기 전 try 구문");
			
			c = a / b02;
			System.out.println(" (1) c -> " + c);
			
			c = a / b01;
			System.out.println(" (2) c -> " + c);
			
			c = a / b02;
			System.out.println(" (3) c -> " + c);
			
		} catch(ArithmeticException e) {
			System.out.println("예외가 발행하여 ArithmeticException 객체가 잡음 ->" + e);
		} catch(Exception e) {
			System.out.println("예외가 발행하여 Exception 객체가 잡음 ->" + e);
		} finally {
			System.out.println("try/catch 구문에 대한 정리 작업 c-->" + c);
		}
		
		System.out.println("try 구문을 수행한 후 c-->" + c);
		
	}
	
}
