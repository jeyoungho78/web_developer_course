package exec.mathematics;

import data.mathematics.MathematicsData;
import logic.mathematics.MathemeticsLogic;

public class MathemeticsExec {
	
	public static void main(String[] args) {
		MathematicsData md = new MathematicsData();
		md.setFirstNum(1);
		md.setSecondNum(2);
		
		MathemeticsLogic ml = new MathemeticsLogic();
		int x = ml.minus(md.getFirstNum(), md.getSecondNum());
		
		System.out.println(x);
	}//main

}
