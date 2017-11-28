package exec;

import logic.ArrayManager;

public class ArrayMain {

	public static void main(String[] args) {
		
		int[] arr = {5, 2, 1, 6, 7};
		String str = "";
		
		ArrayManager arrMng = new ArrayManager(arr);
		str = arrMng.printBubbleSortArray();
		
		System.out.println(str);
	}
	
}
