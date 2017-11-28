package exec.io;

import java.util.*;

import data.io.PersonalInfoData;
import logic.io.*;

public class PersonalInfoInputStreamExec {
	public static void main(String[] args) {
		String inputFile = "c:/temp/PersonalnfoData.txt";
		
		try {
			PersonalInfoInputStreamLogic piisfl = new PersonalInfoInputStreamLogic(inputFile);
			List<PersonalInfoData> listPersonalInfo = piisfl.readAll();
			piisfl.print(listPersonalInfo);
			piisfl.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
