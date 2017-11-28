package exec.exception;

class DivideException extends Exception {
	
	DivideException(){
		super();
	}
	
	DivideException(String message) {
		super(message);
	}
	
}

class CalculatorEx {
	
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void divide( ) throws DivideException{
//		if(right == 0) {
//			try {
//				throw new DivideException("0���� ������ ���� ������ �ʽ��ϴ�.");
//			} catch (DivideException e) {
//				e.printStackTrace();
//			}
//		}
		
		if(right == 0) {
			throw new DivideException("0���� ������ ���� ������ �ʽ��ϴ�.");
		}
		
		System.out.println(this.left/this.right);
	}
}

public class CalculatorDemoEx {
	public static void main(String[] args) {
		CalculatorEx cl = new CalculatorEx();
		cl.setOprands(10, 0);
		
		try {
			cl.divide();
		} catch (DivideException e) {
			e.printStackTrace();
		}
	}
}
