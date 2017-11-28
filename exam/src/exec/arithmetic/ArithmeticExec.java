package exec.arithmetic;

import data.arithmetic.ArithmeticData;
import logic.arithmetic.ArithmeticLogic;

public class ArithmeticExec {
	public static void main(String[] args) {
		ArithmeticData ad = new ArithmeticData();
		ad.setFirstNum(2);
		ad.setSecondNum(3);
		
		ArithmeticLogic al = new ArithmeticLogic();
		int x = al.sum(ad.getFirstNum(), ad.getSecondNum());
		
		System.out.println(x);
	}//main
}
