package exec.rank;

import java.util.HashMap;
import java.util.Random;

import data.rank.Data;
import logic.rank.Logic;

public class Exec {

	public static void main(String[] args) {

		String[] names = { "단군", "이성계", "동명왕", "박혁거세", "관창", "김유신", "선덕여왕", "장보고", "대조영", "의천" };
		String[] subjects = { "국어", "영어", "수학", "체육" };
		int[] scores = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		// 데이터 넣기
		HashMap<String, HashMap<String, Integer>> hashTmp = new HashMap<String, HashMap<String, Integer>>(); // 이름 , <과목 , 점수>
		HashMap<String, Data> hashInput = new HashMap<String, Data>();
		Random rd = new Random();

		int namesCnt = names.length;
		int subjectsCnt = subjects.length;
		int scoresCnt = scores.length;
		int namesIndex = -1;
		int subjectsIndex = -1;
		int scoresIndex = -1;
		String namesKey = "";
		String subjectsKey = "";
		int scoresValue = -1;

		int totalsum = 0;
		double totalavg = 0.0;

		// 학생이름
		while (true) {
			if (hashTmp.size() == namesCnt) { // 모든 인원 점수가 다 찾으면 끝
				break;
			}
			namesIndex = rd.nextInt(namesCnt);
			namesKey = names[namesIndex];
			if (!hashTmp.containsKey(namesKey)) { // 같은 이름이 있는지 중복체크 없으면 내부 if문 실행
				HashMap<String, Integer> hashValue = new HashMap<String, Integer>();
				Data dt = new Data();
				totalsum = 0;
				totalavg = 0.0;
				dt.setName(namesKey);
				while (true) {
					if (hashValue.size() == subjectsCnt) { // 모든 과목이 다입력 되었으면 끝
						break;
					}
					subjectsIndex = rd.nextInt(subjectsCnt);
					subjectsKey = subjects[subjectsIndex];
					if (!hashValue.containsKey(subjectsKey)) {// 같은 이름의 과목이 있는지 중복체크 없으면 내부 if문 실행
						scoresIndex = rd.nextInt(scoresCnt);
						scoresValue = scores[scoresIndex];

						switch (subjects[subjectsIndex]) {
						case "국어":
							dt.setKor(scoresValue);
							break;
						case "영어":
							dt.setEng(scoresValue);
							break;
						case "수학":
							dt.setMath(scoresValue);
							break;
						case "체육":
							dt.setPhysic(scoresValue);
							break;
						}
						totalsum = totalsum + scoresValue;
						dt.setTotalsum(totalsum);
						
						hashValue.put(subjectsKey, scoresValue);
					}
				} // while2
				totalavg = (double)totalsum/subjectsCnt;
				dt.setTotalavg(totalavg);
				
				hashTmp.put(namesKey, hashValue);
				hashInput.put(namesKey, dt);
			}
		} // while1
		
		try {
			Logic lg = new Logic();
			lg.printRank(hashInput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}//main

}//class
