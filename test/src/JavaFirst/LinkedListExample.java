package JavaFirst;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExample {
	
	public static void main(String[] args) {
		
		LinkedList<String> llist = new LinkedList<>();
		ArrayList<String> alist = new ArrayList<>();
		
		long sttime;
		long endtime;
		long calctime;
		
		llist.add("end");
		alist.add("end");
		
		sttime = System.nanoTime();
		for(int x=0; x<5000; x++) {
			llist.add(x, String.valueOf(x));
		}
		endtime = System.nanoTime();
		calctime = endtime = sttime;
		System.out.println("LinkedList °´Ã¼ »ðÀÔ ÃøÁ¤ ½Ã°£ : " + "\t" + calctime);
		
		
		sttime = System.nanoTime();
		for(int x=0; x<5000; x++) {
			alist.add(x, String.valueOf(x));
		}
		endtime = System.nanoTime();
		calctime = endtime = sttime;
		System.out.println("ArrayList °´Ã¼ »ðÀÔ ÃøÁ¤ ½Ã°£ : " + "\t" + calctime);
	}
	
	
}
