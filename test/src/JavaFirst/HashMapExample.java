package JavaFirst;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		
		HashMap<String, String> ht = new HashMap<String, String>();
		ht.put("Grapes", "포도");
		ht.put("Apple", "사과");
		ht.put("Strawberry", "딸기");
		ht.put("Orange", "오렌지");
		System.out.println("hashMap의 키의 수 : " + ht.size());
		System.out.println("hashMap의 키로 값을 찾음 : " + (String)ht.get("Apple"));
		System.out.println();
		
		String k, v;
		Set<String> keyset = ht.keySet();
		Iterator<String> keyiterator = keyset.iterator();
		while(keyiterator.hasNext()) {
			k = (String)keyiterator.next();
			v = (String)ht.get(k);
			System.out.println("키 : " + k + " ----> 값 : " + v);
		}
		
	}
	
}
