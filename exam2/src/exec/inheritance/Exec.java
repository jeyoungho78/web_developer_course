package exec.inheritance;

import data.inheritance.Data;
import logic.inheritance.ChildLogic;
import logic.inheritance.ParentLogic;

public class Exec {

	public static void main(String[] args) {
		
		// 일반 정수
		Data dt = new Data();
		dt.setA(5);
		
		ChildLogic cl = new ChildLogic();
		cl.calcSum(dt.getA());
		cl.calcAvg(dt.getA());
		
		// 배열 정수 
		int[] array = {1, 3, 5, 7, 9};
		Data dt2 = new Data();
		dt2.setArray(array);
		
		ChildLogic cl2 = new ChildLogic(dt2.getArray());
		cl2.calcSumArray(dt2.getArray());
		
		// 클래스 배열
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {6, 7, 8, 9, 10};
		Data d1 = new Data();
		d1.setArray(a);
		Data d2 = new Data();
		d2.setArray(b);
		
		Data[] arrData = {d1, d2};
		Data d3 = new Data();
		d3.setArrData(arrData);
		
		ChildLogic cl3 = new ChildLogic(d3);
		cl3.calcSumDataArray();
		
	}//main
	
}//class
