package exec;

import logic.JumsuChildLogic;

public class JumsuExec {

	public static void main(String[] args) {
		
		int[] a = {10, 20 ,30};
		int[] b = {40, 50 ,60};
		int[] c = {70, 80 ,90};
		
		JumsuChildLogic jcl = new JumsuChildLogic(a, b, c);
		
		jcl.calcTotalSum();
		jcl.calcTotalAvg();
		
	}// main
	
}//class
