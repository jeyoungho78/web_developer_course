package logic.inheritance;

import data.inheritance.Data;

public class ChildLogic extends ParentLogic{

	public ChildLogic() {
		
	}

	public ChildLogic(int[] array) {
		super(array);
	}
    
	public ChildLogic(Data dt) {
		super(dt);
	}

	public int calcSum(int a) {
		super.calcSum(a);
		
		int sum = 0;
		for(int i=1; i<=a; i++) {
			if(i%2 != 0) {
				sum = sum + i;
			}
		}
		System.out.println("�ڽ� calcSum()ȣ��!! : " + sum);
		
		return sum;
	}//calcSum
	
	public double calcAvg(int a) {
		double avg = super.calcSum(a) / a;
		System.out.println("�ڽ� calcAvg()ȣ��!! : " + avg);
		return avg;
	}//calcAvg
}
