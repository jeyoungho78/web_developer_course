package JavaFirst;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		
		HashMap<String, String> ht = new HashMap<String, String>();
		ht.put("Grapes", "����");
		ht.put("Apple", "���");
		ht.put("Strawberry", "����");
		ht.put("Orange", "������");
		System.out.println("hashMap�� Ű�� �� : " + ht.size());
		System.out.println("hashMap�� Ű�� ���� ã�� : " + (String)ht.get("Apple"));
		System.out.println();
		
		String k, v;
		Set<String> keyset = ht.keySet();
		Iterator<String> keyiterator = keyset.iterator();
		while(keyiterator.hasNext()) {
			k = (String)keyiterator.next();
			v = (String)ht.get(k);
			System.out.println("Ű : " + k + " ----> �� : " + v);
		}
		
	}
	
}
