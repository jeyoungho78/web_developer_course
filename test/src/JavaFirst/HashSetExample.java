package JavaFirst;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetExample {

	public static void main(String[] args) {
		
		HashSet<String> set = new LinkedHashSet<>();
		set.add("VB");
		set.add("JAVA");
		set.add("VB");
		set.add("C");
		
		System.out.println("set�� ������ ���� : " + set.size());
		set.remove("C");
		System.out.println("set�� ������ ���� : " + set.size());
		
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
	}
	
}
