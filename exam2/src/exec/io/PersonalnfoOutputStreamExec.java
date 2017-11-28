package exec.io;

import java.io.*;
import java.util.*;

import data.io.PersonalInfoData;
import logic.io.PersonalInfoOutputStreamLogic;

public class PersonalnfoOutputStreamExec {
	public static void main(String[] args) {
		String outputFile = "c:/temp/PersonalnfoData.txt";
		
		List<PersonalInfoData> listPersonalInfo = new ArrayList<PersonalInfoData>();
		listPersonalInfo.add(new PersonalInfoData("»´±Êµø", "2006-02-26", true, 11, 2));
		listPersonalInfo.add(new PersonalInfoData("º∫√·«‚", "1991-05-30", false, 26, 3));
		listPersonalInfo.add(new PersonalInfoData("¿”≤©¡§", "1970-11-11", true, 47, 5));
		
		try {
			PersonalInfoOutputStreamLogic piosfl = new PersonalInfoOutputStreamLogic(outputFile);
			piosfl.write(listPersonalInfo);
			piosfl.save();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
