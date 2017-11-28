package logic.dice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import data.dice.DiceData;

public class DiceLogic {

	DiceData dd;

	public DiceLogic(DiceData dd) {
		this.dd = dd;
	}

	public ArrayList diceAccum() {	
		int[] diceNumberCnt = new int[6];
		int maxCnt = 3000;
		int number = -1;
		
		Random rd = new Random();
		
		for (int i = 1; i <= maxCnt; i++) {
			number = rd.nextInt(6) + 1;
			switch (number) {
			case 1:
				diceNumberCnt[0]++;
				break;
			case 2:
				diceNumberCnt[1]++;
				break;
			case 3:
				diceNumberCnt[2]++;
				break;
			case 4:
				diceNumberCnt[3]++;
				break;
			case 5:
				diceNumberCnt[4]++;
				break;
			case 6:
				diceNumberCnt[5]++;
				break;
			}
		}

		// arraylist에 반환 결과 담기
		double dice = -1;
		ArrayList list = new ArrayList();
		for (int i = 0; i < diceNumberCnt.length; i++) {
			dice = ((double)(diceNumberCnt[i]) / maxCnt) * 100;
			list.add(dice);
		}

		return list;
	}

	public HashMap diceProb(ArrayList list) throws Exception {
		HashMap hashMap = new HashMap();
		
		for (int i = 0; i < list.size(); i++) {
			hashMap.put(i + 1, list.get(i));
			System.out.println("key : " + (i+1) + " value : " + hashMap.get(i+1));
			if((double)list.get(i) <= 15) {
				throw new Exception("15% 이하는 에러 발생합니다.");
			}
		}
		
		return hashMap;
	}

	public void printDiceList(ArrayList list) {
		for(int i=0; i < list.size(); i++) {
			System.out.println("인덱스 : " + i + " 값 : " + list.get(i));
		}
	}

	public void printDiceProb(HashMap hashMap) {
		if(hashMap == null) {
			throw new NullPointerException("hashMap은 null입니다.");
		}
		
		Set keyset = hashMap.keySet();
		Iterator iterator = keyset.iterator();
		int key = -1;
		double value = -1;
		while(iterator.hasNext()) {
			key = (int)iterator.next();
			value = (double)hashMap.get(key);
			System.out.println("키 : " + key + " 값 : " + value);
		}
	}

}
