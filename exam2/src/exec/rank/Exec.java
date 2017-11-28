package exec.rank;

import java.util.HashMap;
import java.util.Random;

import data.rank.Data;
import logic.rank.Logic;

public class Exec {

	public static void main(String[] args) {

		String[] names = { "�ܱ�", "�̼���", "�����", "�����ż�", "��â", "������", "��������", "�庸��", "������", "��õ" };
		String[] subjects = { "����", "����", "����", "ü��" };
		int[] scores = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		// ������ �ֱ�
		HashMap<String, HashMap<String, Integer>> hashTmp = new HashMap<String, HashMap<String, Integer>>(); // �̸� , <���� , ����>
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

		// �л��̸�
		while (true) {
			if (hashTmp.size() == namesCnt) { // ��� �ο� ������ �� ã���� ��
				break;
			}
			namesIndex = rd.nextInt(namesCnt);
			namesKey = names[namesIndex];
			if (!hashTmp.containsKey(namesKey)) { // ���� �̸��� �ִ��� �ߺ�üũ ������ ���� if�� ����
				HashMap<String, Integer> hashValue = new HashMap<String, Integer>();
				Data dt = new Data();
				totalsum = 0;
				totalavg = 0.0;
				dt.setName(namesKey);
				while (true) {
					if (hashValue.size() == subjectsCnt) { // ��� ������ ���Է� �Ǿ����� ��
						break;
					}
					subjectsIndex = rd.nextInt(subjectsCnt);
					subjectsKey = subjects[subjectsIndex];
					if (!hashValue.containsKey(subjectsKey)) {// ���� �̸��� ������ �ִ��� �ߺ�üũ ������ ���� if�� ����
						scoresIndex = rd.nextInt(scoresCnt);
						scoresValue = scores[scoresIndex];

						switch (subjects[subjectsIndex]) {
						case "����":
							dt.setKor(scoresValue);
							break;
						case "����":
							dt.setEng(scoresValue);
							break;
						case "����":
							dt.setMath(scoresValue);
							break;
						case "ü��":
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
