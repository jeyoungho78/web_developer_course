package logic.inheritance;

import data.inheritance.Data;

public class ParentLogic {

	int[] array;
	Data dt;
	
	public ParentLogic() {
		
	}
	
	public ParentLogic(int[] array) {
		this.array = array;
	}

	public ParentLogic(Data dt) {
		this.dt = dt;
	}

	public int calcSum(int a) {
		int sum = 0;
		for(int i=1; i<=a; i++) {
			sum = sum + i;
		}
		
		System.out.println("부모 calcSum()호출!! : " + sum);
		
		return sum;
		
	}//calcSum
	
	public int calcSumArray(int[] a) {
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			sum = sum + a[i];
		}
		
		System.out.println("부모 calcSumArray()호출!! : " + sum);
		
		return sum;
	}
	
	public int calcSumDataArray() {
		Data[] arrData = dt.getArrData();
		int arrDataLen = arrData.length;
		
		int sum = 0;
		for(int i=0; i<arrDataLen; i++) {
			int[] array = arrData[i].getArray();
			for(int j=0; j<array.length; j++) {
				sum = sum + array[j];
			}
			System.out.println("Data" + i + " 까지의 합 : " + sum);
		}
		return sum;
	}
	
}//class
