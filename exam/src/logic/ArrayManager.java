package logic;

public class ArrayManager {

	int[] arr;
	
	public ArrayManager(int[] arr) {
		this.arr = arr;
	}
	
	public String printBubbleSortArray() {
		String str = "";
		int tmp = 0;
		
		// 버블정렬
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for(int k=0; k<arr.length; k++) {
			str = str + " " + arr[k];
		}
		
		return str;
	}

}
