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
		
		//1. hashmap���� ������ ���� 
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
		
		// 2. ��ü ��� 50������ ����ó��
		if(avgOfSumOfDataAvg < 50) {
			throw new Exception("��ü ��� 50���ϴ� ���ܹ߻�");
		}
		
		String nameTmp = "";
		double avgTmp = 0.0;
		
		// 3. ��ռ����� �̸� ����
		for (int i = 0; i < avgArr.length; i++) {
			for(int j = 0; j < avgArr.length - i - 1; j++) {
				if(avgArr[j] < avgArr[j+1]) {
					// ��� �迭
					avgTmp = avgArr[j+1];
					avgArr[j+1] = avgArr[j];
					avgArr[j] = avgTmp;
					
					// �̸� �迭  
					nameTmp = nameArr[j+1];
					nameArr[j+1] = nameArr[j];
					nameArr[j] = nameTmp;
				}
				
			}
		}
		
		int rank = 0;
		String name = "";
		
		// 4. ��ŷ������ ��� 
		for (int i = 0; i < nameArr.length; i++) {
			rank = rank + 1;
			name = nameArr[i];
			Data dt = (Data)hash.get(name);
			
			System.out.println("���� : " + rank + "\t �̸� : " + name + "\t ���� : " + dt.getKor() 
			+ "\t ���� : " + dt.getEng() + "\t ���� : " + dt.getMath() 
			+ "\t ü�� : " + dt.getPhysic() + "\t ��� : " + dt.getTotalavg());
		}
		
	}

}
