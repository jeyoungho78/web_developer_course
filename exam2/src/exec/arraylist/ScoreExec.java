package exec.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.arraylist.ScoreData;
import logic.arraylist.ScoreLogic;

public class ScoreExec {

	private static void setElement(ScoreData sd, int memeberindex, String element) {
		
		switch (memeberindex) {
		case 0:
			sd.setName(element);
			break;
		case 1:
			sd.setKor(Integer.valueOf(element));
			break;
		case 2:
			sd.setEng(Integer.valueOf(element));
			break;
		case 3:
			sd.setMath(Integer.valueOf(element));
			break;
		}
	} //setElement 
	
	public static ScoreData setData(String str, String delimiter) {
		int beginIndex = -1;
		int endIndex = -1;
		String element = "";

		ScoreData sd = new ScoreData();
		
		for (int i = 0; i < str.length(); i++) {
			beginIndex = endIndex;
			endIndex = str.indexOf(delimiter, beginIndex + 1);

			if (endIndex >= 0) {
				element = str.substring(beginIndex + 1, endIndex);
				setElement(sd, i, element);
			} else {
				element = str.substring(beginIndex + 1);
				setElement(sd, i, element);
				break;
			}
		}

		return sd;
	} // setData

	public static void main(String[] args) {

		// raw data
		String[] arrStudentData = { "홍길동^10^20^30", "김구^40^50^60", "이순신^70^80^90" };
		int arrStudentData_cnt = arrStudentData.length;
		
		// raw data를 구분자로 쪼개서  ScoreData 클래스에 담기
		String delimiter = "^";
		List<ScoreData> list = new ArrayList<ScoreData>();
		for (int i = 0; i < arrStudentData_cnt; i++) {
			list.add(setData(arrStudentData[i], delimiter));
		}
		
		// 로직 클래스 수행 
		ScoreLogic sl = new ScoreLogic(list);
		sl.printStudentData();
		
		
		String[] arrStudentName = { "홍길동", "김구", "이순신" };
		int arrStudentName_cnt = arrStudentName.length;
		
		delimiter = "^";
		Map<String, ScoreData> hash = new HashMap<String, ScoreData>();
		for (int i = 0; i < arrStudentName_cnt; i++) {
			hash.put(arrStudentName[i], setData(arrStudentData[i], delimiter));
		}
		
		ScoreLogic sl2 = new ScoreLogic(hash);
		sl2.printStudentData2();

	}

}
