package JavaFirst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//import Data.ScoreRanData;

public class ScoreRanExec {
	public static void main(String[] args) {
		
		
		String[] name = {"�ܱ�", "�̼���", "�����", "�����ż�", "��â", 
						"������", "��������", "�庸��", "������", "��õ"};
		String[] subject = {"����", "����", "����", "ü��"};
		int[] score= {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

		
		String x="";	//�̸�
		String y="";	//����
		
		
		
		Random ran = new Random();
		
		ArrayList<ScoreRanData> list = new ArrayList<ScoreRanData>();
		
		//list.add(x);
		//list.add(y);
		
		//ScoreRanData d1= new ScoreRanData();	
		//ScoreRanData d2= new ScoreRanData();
		
		
		while(true) {
			int rName = ran.nextInt(name.length);		//�̸� ����
			//System.out.println(rName);
			//System.out.println(name[rName]);
			
			if(x.indexOf(""+rName) == -1){
				ScoreRanData d1 = new ScoreRanData();
				
				//System.out.println(name[rName]);
				d1.name = name[rName];
				
				while(true) {
					
					int rSubject = ran.nextInt(subject.length);	//���� ����
					
					if(y.indexOf(""+rSubject) == -1) {
					
						int rScore = ran.nextInt(score.length);
						
						y = y+rSubject;		//����		
						
						if(subject[rSubject].equals("����")) {
							d1.kor = score[rScore];
						}else if(subject[rSubject].equals("����")) {
							d1.eng = score[rScore];
						}else if(subject[rSubject].equals("����")) {
							d1.math = score[rScore];
						}else if(subject[rSubject].equals("ü��")) {
							d1.physicalEducation = score[rScore];
						}
						
						//System.out.println(y);
					}else if(y.length() == 4) {
						d1.avg2();
						break;
					}
					
				}//while
				x=x+rName;	//�̸� 
				list.add(d1);
			}else if(x.length() == 10) {
				break;
			}
			y = "";
		}//while
		
		Collections.sort(list);
		
		
		for(int i = 0 ; i < list.size() ; i++) {
			ScoreRanData tmp = list.get(i);
			System.out.println((i+1) + "��        " + tmp.avg + "    " + tmp.name + " " + tmp.kor + " " + tmp.eng + " " + tmp.math + " " + tmp.physicalEducation);
		}
		
		
	
	}//main
}
