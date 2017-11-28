package exec.mathematics;

import data.mathematics.ParentExamData;
import logic.mathematics.ChildLogic;

public class ParentExamExec {

	public static void main(String[] args) {
		ParentExamData pd = new ParentExamData();
		pd.setFirstNum(1);
		pd.setSecondNum(2);
		
		ChildLogic cl = new ChildLogic();
		int x = cl.sum(pd.getFirstNum(), pd.getSecondNum());
		int y = cl.minus(pd.getFirstNum(), pd.getSecondNum());
		
		System.out.println(x);
		System.out.println(y);
		
	}
	
}
