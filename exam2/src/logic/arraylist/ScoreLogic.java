package logic.arraylist;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.arraylist.ScoreData;

public class ScoreLogic {

	List<ScoreData> list;
	Map<String, ScoreData> hash;
	
	public ScoreLogic(List<ScoreData> list) {
		this.list = list;
	}

	public ScoreLogic(Map<String, ScoreData> hash) {
		this.hash = hash;
	}

	public void printStudentData() {
		for(int i = 0; i < list.size(); i++) {
			System.out.println("이름 : " + ((ScoreData)list.get(i)).getName());
			System.out.println("국어 : " + ((ScoreData)list.get(i)).getKor());
			System.out.println("영어 : " + ((ScoreData)list.get(i)).getEng());
			System.out.println("수학 : " + ((ScoreData)list.get(i)).getMath());
			System.out.println("===========================================");
		}
		
	}

	public void printStudentData2() {
		Set<String> keyset = hash.keySet();
		Iterator<String> iterator = keyset.iterator();
		while(iterator.hasNext()) {
			String key = (String)iterator.next();
			ScoreData value = (ScoreData)hash.get(key);
			
			System.out.println("Key : " + key + " --------> Value : " + value.toString());
		}
	}

}
