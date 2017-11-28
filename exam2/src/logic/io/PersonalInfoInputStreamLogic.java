package logic.io;

import java.util.*;
import java.io.*;
import java.text.*;

import data.io.PersonalInfoData;

public class PersonalInfoInputStreamLogic {

	ObjectInputStream oips;
	
	public PersonalInfoInputStreamLogic(String inputFile) {
		try {
			this.oips = new ObjectInputStream(new FileInputStream(new File(inputFile)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<PersonalInfoData> readAll() {
		List<PersonalInfoData> listPersonalInfo = null;
		
		try {
			listPersonalInfo = new ArrayList<PersonalInfoData>();
			
			while(true) {
				PersonalInfoData personalInfo = (PersonalInfoData)oips.readObject();
				listPersonalInfo.add(personalInfo);
			}
		} catch (EOFException e) {
			System.out.println("읽기 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listPersonalInfo;
	}

	public void print(List<PersonalInfoData> listPersonalInfo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(PersonalInfoData personalInfo : listPersonalInfo) {
			System.out.print("" + personalInfo.getName() + "\t");
			System.out.print("" + sdf.format(personalInfo.getBirthday()) + "\t");
			System.out.print("" + personalInfo.isGender() + "\t");
			System.out.print("" + personalInfo.getAge() + "\t");
			System.out.print("" + personalInfo.getGrade() + "\t");
			System.out.println();
		}
	}
	
	public void close() {
		try {
			oips.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
