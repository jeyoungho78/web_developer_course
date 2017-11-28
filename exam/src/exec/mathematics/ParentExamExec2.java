package exec.mathematics;

import data.mathematics.ParentExamData2;
import logic.mathematics.ChildALogic2;
import logic.mathematics.ChildBLogic2;

public class ParentExamExec2 {

	public static void main(String[] args) {
		
		ParentExamData2 pd2 = new ParentExamData2();
		pd2.setFirstNum(3);
		pd2.setSecondNum(5);
		
		ChildALogic2 cal2 = new ChildALogic2();
		int x = cal2.sum(pd2.getFirstNum(), pd2.getSecondNum());
		int y = cal2.minus(pd2.getFirstNum(), pd2.getSecondNum());
		System.out.println(x);
		System.out.println(y);
		
		ChildBLogic2 cbl2 = new ChildBLogic2();
		int w = cbl2.sum(pd2.getFirstNum(), pd2.getSecondNum());
		int z = cbl2.multi(pd2.getFirstNum(), pd2.getSecondNum());
		System.out.println(w);
		System.out.println(z);
		
	}//main
	
}
