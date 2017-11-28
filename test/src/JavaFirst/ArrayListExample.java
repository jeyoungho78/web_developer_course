package JavaFirst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Pig");
		list.add("Dog");
		list.add("Cow");
		System.out.println("ArrayList °´Ã¼ ¼ö: " + list.size());
		
		list.add("Snake");
		list.add(2, "Cat");
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + "      ");
		}
		System.out.println();
		list.remove(3);
		
		Iterator e = list.iterator();
		while(e.hasNext()) {
			System.out.print(e.next() + "      ");
		}
		System.out.println();
		list.remove("Pig");
		
	}
	
}
