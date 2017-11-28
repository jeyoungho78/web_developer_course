package exec.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.arraylist.Data;

public class Exec {
	
	public static void setMemberData (Data dt, String str) {
		int pos = -1;
		int next_pos = -1;
		String element = "";
		
		for(int i=0; i < str.length(); i++) {
			next_pos = str.indexOf("^", next_pos + 1);
			
			if(next_pos < 0) {
				element = str.substring(pos + 1);
				if(i == 3) {
					dt.setMath(Integer.valueOf(element));
				}
				System.out.println("pos : " + pos + " next_pos : " + next_pos + " element : " + element);
				break;
			}
			
			element = str.substring(pos + 1, next_pos);
			pos = next_pos;
			
			if(i == 0) {
				dt.setName(element);
			} else if (i==1) {
				dt.setKor(Integer.valueOf(element));
			} else if (i==2) {
				dt.setEng(Integer.valueOf(element));
			}
			
			System.out.println("pos : " + pos + " next_pos : " + next_pos + " element : " + element);
		}
	}
	
	public static void split (String str, String regex) {
		int pos = -1;
		int next_pos = -1;
		String element = "";
		
		for(int i=0; i < str.length(); i++) {
			next_pos = str.indexOf("^", next_pos + 1);
			
			if(next_pos < 0) {
				element = str.substring(pos + 1);
				break;
			}
			
			element = str.substring(pos + 1, next_pos);
			pos = next_pos;
		}
	}
	
	public static Data setData (String str) {
		int pos = -1;
		int next_pos = -1;
		//String element = "";
		
		Data dt = new Data();
		
		for(int i=0; i < str.length(); i++) {
			next_pos = str.indexOf("^", next_pos + 1);
			
			if(i == 0) {
				dt.setName(str.substring(pos + 1, next_pos));
			} else if (i==1) {
				dt.setKor(Integer.valueOf(str.substring(pos + 1, next_pos)));
			} else if (i==2) {
				dt.setEng(Integer.valueOf(str.substring(pos + 1, next_pos)));
			} else if (i==3) {
				dt.setMath(Integer.valueOf(str.substring(pos + 1)));
			}
			
			pos = next_pos;
		}
		
		return dt;
	}

	public static void main(String[] args) {
		
		String str1 = "홍길동^50^90^70";
		String str2 = "이순신^60^70^50";
		String str3 = "김구^100^40^30";
		
		List<Data> list = new ArrayList<Data>();
		//ArrayList<Data> list = new ArrayList<Data>();
		
		list.add(setData(str1));
		list.add(setData(str2));
		list.add(setData(str3));
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("이름 : " + ((Data)list.get(i)).getName());
			System.out.println("국어 : " + ((Data)list.get(i)).getKor());
			System.out.println("영어 : " + ((Data)list.get(i)).getEng());
			System.out.println("수학 : " + ((Data)list.get(i)).getMath());
			System.out.println("=======================================");
		}
		
//		Map<String, Data> hash = new HashMap<String, Data>();
//		//HashMap<String, Data> hash = new HashMap<String, Data>();
//		hash.put("홍길동", setData(str1));
//		hash.put("이순신", setData(str2));
//		hash.put("김구", setData(str3));
//		
//		String key = "";
//		Data value = null;
//		Set<String> keyset = hash.keySet();
//		Iterator<String> iterator = keyset.iterator();
//		while(iterator.hasNext()) {
//			key = (String)iterator.next();
//			value = (Data)hash.get(key);
//			
//			System.out.println("Key : " + key + " --------> Value : " + value.toString());
//		}
		
	}

}
