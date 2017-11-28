package logic.io;

import java.util.*;
import java.io.*;

import data.io.PersonalInfoData;

public class PersonalInfoOutputStreamLogic {
	ObjectOutputStream oops;

	public PersonalInfoOutputStreamLogic(String outputFile) {
		try {
			this.oops = new ObjectOutputStream(new FileOutputStream(new File(outputFile)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void write(List<PersonalInfoData> listPersonalInfo) {
		try {
			for (PersonalInfoData personalInfo : listPersonalInfo) {
				oops.writeObject(personalInfo);
				oops.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			oops.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
