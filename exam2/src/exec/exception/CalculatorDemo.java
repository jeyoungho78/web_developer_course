package exec.exception;

class Calculator {
	
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void divide( ) {
		if(right == 0) {
			throw new IllegalArgumentException("0으로 나누는 것은 허용되지 않습니다.");
		}
		
		try {
			System.out.print("계산결과는 ");
			System.out.print(this.left/this.right);
			System.out.print(" 입니다.");
		} catch (Exception e) {
			System.out.println("\n\ne.getMessage()\n" + e.getMessage());
			System.out.println("\n\ne.toString()\n" + e.toString());
			System.out.println("\n\ne.printStackTrace()\n");
			e.printStackTrace();
		}
	}
}

public class CalculatorDemo {
	
	public static void main(String[] args) {
		Calculator cl = new Calculator();
		cl.setOprands(10,  0);
		cl.divide();
	}
	
}
