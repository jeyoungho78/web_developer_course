package logic.rank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import data.rank.Data;

public class Logic {

	public void printRank(HashMap<String, Data> hash) throws Exception{
		int hashSize = hash.size();
		double[] avgArr = new double[hashSize];
		String[] nameArr = new String[hashSize];
		
		double sumOfDataAvg = 0.0;
		double avgOfSumOfDataAvg= 0.0;
		
		//1. hashmap에서 데이터 추출 
		Set<String> keyset = hash.keySet();
		Iterator<String> iterator = keyset.iterator();
		String key = "";
		Data value = null;
		
		int k = 0;
		while(iterator.hasNext()) {
			key = (String)iterator.next();
			value = hash.get(key);
			
			nameArr[k] = key;
			avgArr[k] = value.getTotalavg();
			k++;
	
			sumOfDataAvg += value.getTotalavg();
		}
		
		avgOfSumOfDataAvg = sumOfDataAvg / hash.size();
		
		// 2. 전체 평균 50점이하 예외처리
		if(avgOfSumOfDataAvg < 50) {
			throw new Exception("전체 평균 50이하는 예외발생");
		}
		
		String nameTmp = "";
		double avgTmp = 0.0;
		
		// 3. 평균순으로 이름 정렬
		for (int i = 0; i < avgArr.length; i++) {
			for(int j = 0; j < avgArr.length - i - 1; j++) {
				if(avgArr[j] < avgArr[j+1]) {
					// 평균 배열
					avgTmp = avgArr[j+1];
					avgArr[j+1] = avgArr[j];
					avgArr[j] = avgTmp;
					
					// 이름 배열  
					nameTmp = nameArr[j+1];
					nameArr[j+1] = nameArr[j];
					nameArr[j] = nameTmp;
				}
				
			}
		}
		
		int rank = 0;
		String name = "";
		
		// 4. 랭킹순으로 출력 
		for (int i = 0; i < nameArr.length; i++) {
			rank = rank + 1;
			name = nameArr[i];
			Data dt = (Data)hash.get(name);
			
			System.out.println("순위 : " + rank + "\t 이름 : " + name + "\t 국어 : " + dt.getKor() 
			+ "\t 영어 : " + dt.getEng() + "\t 수학 : " + dt.getMath() 
			+ "\t 체육 : " + dt.getPhysic() + "\t 평균 : " + dt.getTotalavg());
		}
		
	}

}
