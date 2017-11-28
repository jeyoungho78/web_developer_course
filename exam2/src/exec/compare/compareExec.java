package exec.compare;

public class compareExec {
	
	public static int multiValue(Integer a, Integer b) {
		
		int result = a.compareTo(b);
		int calc_result = 1;
		
		if(result == 0) { // 같을 때
			for(int i=1; i<=a; i++) {
				calc_result = calc_result * a;
				System.out.print(a + " x ");
			}
		} else if (result > 0) { // 클때
			for(int i=1; i<=b; i++) {
				if(i%2 == 0) {
					calc_result = calc_result * b;
					System.out.print(b + " x ");
				} else {
					calc_result = calc_result * a;
					System.out.print(a + " x ");
				}
				
			}
		} else { // 작을때
			for(int i=1; i<=a; i++) {
				if(i%2 == 0) {
					calc_result = calc_result * b;
					System.out.print(b + " x ");
				} else {
					calc_result = calc_result * a;
					System.out.print(a + " x ");
				}
			}
		}
		
		System.out.println();
		System.out.println("calc_result : " + calc_result);
		
		return calc_result;
	}
	
	public static void main(String[] args) {
		Integer a = new Integer(8);
		Integer b = new Integer(7);
		
		int result = multiValue(a, b);
		
		System.out.println("최종 결과 : " + result);
		
	}
	
	
	/*public static void main(String[] args) {
		
		Integer a = new Integer(3);
		Integer b = new Integer(3);
		
		int result = a.compareTo(b);
		int calc_result = 1;
		
		if(result == 0) { // 같을 때
			for(int i=1; i<=a; i++) {
				calc_result = calc_result * a;
				System.out.print(a + " x ");
			}
		} else if (result > 0) { // 클때
			for(int i=1; i<=b; i++) {
				if(i%2 == 0) {
					calc_result = calc_result * b;
					System.out.print(b + " x ");
				} else {
					calc_result = calc_result * a;
					System.out.print(a + " x ");
				}
				
			}
		} else { // 작을때
			for(int i=1; i<=a; i++) {
				if(i%2 == 0) {
					calc_result = calc_result * b;
					System.out.print(b + " x ");
				} else {
					calc_result = calc_result * a;
					System.out.print(a + " x ");
				}
			}
		}
		
		System.out.println();
		System.out.println("calc_result : " + calc_result);
		
	}//main 
*/
}//class
