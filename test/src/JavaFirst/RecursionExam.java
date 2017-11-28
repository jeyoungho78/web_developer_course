package JavaFirst;

public class RecursionExam {
	
	static void hi(int n) {
		if(n <= 0) {
			return;
		}
		hi(n - 1); // Àç±ÍÈ£Ãâ
		System.out.println("Call Number: " + n);
	}
	
	static int sum(int n) {
		if(n <= 0) {
			return 0;
		}
		return n + sum(n-1);
	}
	
	
	public static void main(String[] args) {
		hi(5);
		
		System.out.println(sum(10));
	}
	
}
