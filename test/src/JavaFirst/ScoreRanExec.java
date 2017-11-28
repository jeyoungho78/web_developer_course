package JavaFirst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//import Data.ScoreRanData;

public class ScoreRanExec {
	public static void main(String[] args) {
		
		
		String[] name = {"단군", "이성계", "동명왕", "박혁거세", "관창", 
						"김유신", "선덕여왕", "장보고", "대조영", "의천"};
		String[] subject = {"국어", "영어", "수학", "체육"};
		int[] score= {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

		
		String x="";	//이름
		String y="";	//과목
		
		
		
		Random ran = new Random();
		
		ArrayList<ScoreRanData> list = new ArrayList<ScoreRanData>();
		
		//list.add(x);
		//list.add(y);
		
		//ScoreRanData d1= new ScoreRanData();	
		//ScoreRanData d2= new ScoreRanData();
		
		
		while(true) {
			int rName = ran.nextInt(name.length);		//이름 랜덤
			//System.out.println(rName);
			//System.out.println(name[rName]);
			
			if(x.indexOf(""+rName) == -1){
				ScoreRanData d1 = new ScoreRanData();
				
				//System.out.println(name[rName]);
				d1.name = name[rName];
				
				while(true) {
					
					int rSubject = ran.nextInt(subject.length);	//과목 랜덤
					
					if(y.indexOf(""+rSubject) == -1) {
					
						int rScore = ran.nextInt(score.length);
						
						y = y+rSubject;		//과목		
						
						if(subject[rSubject].equals("국어")) {
							d1.kor = score[rScore];
						}else if(subject[rSubject].equals("영어")) {
							d1.eng = score[rScore];
						}else if(subject[rSubject].equals("수학")) {
							d1.math = score[rScore];
						}else if(subject[rSubject].equals("체육")) {
							d1.physicalEducation = score[rScore];
						}
						
						//System.out.println(y);
					}else if(y.length() == 4) {
						d1.avg2();
						break;
					}
					
				}//while
				x=x+rName;	//이름 
				list.add(d1);
			}else if(x.length() == 10) {
				break;
			}
			y = "";
		}//while
		
		Collections.sort(list);
		
		
		for(int i = 0 ; i < list.size() ; i++) {
			ScoreRanData tmp = list.get(i);
			System.out.println((i+1) + "등        " + tmp.avg + "    " + tmp.name + " " + tmp.kor + " " + tmp.eng + " " + tmp.math + " " + tmp.physicalEducation);
		}
		
		
	
	}//main
}
