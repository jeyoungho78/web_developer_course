package exec.equals;

import data.equals.Data;
import logic.equals.ChildLogic;
import logic.equals.ParentLogic;

public class Exec {
		
	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {2, 1, 4, 5, 3};
		
		Data dt1 = new Data();
		Data dt2 = new Data();
		
		dt1.setArr(a);
		dt2.setArr(b);
		
		// ��ĳ���� �� . (�ڽ� -> �θ�) Ÿ������ ��ȯ
		ParentLogic pl = new ChildLogic(dt1);
		ParentLogic p2 = new ChildLogic(dt2);
		
		// �θ� equal�� �����ϱ� �θ� Ÿ������ �� 
		System.out.println(pl.equals(p2));
		
	}// main
	
}// class
