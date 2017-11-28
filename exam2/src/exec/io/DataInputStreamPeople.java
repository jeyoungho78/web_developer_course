package exec.io;

import java.io.*;
import java.util.*;

import data.io.PeopleData;

public class DataInputStreamPeople {

	DataInputStream dataInput;
	
	public DataInputStreamPeople(String inputFile) throws IOException {
		dataInput = new DataInputStream(new FileInputStream(inputFile));
	}
	
	public List<PeopleData> readAll() throws IOException {
		List<PeopleData> listStudent = new ArrayList<PeopleData>();
		
		try {
			String name;
			boolean gender;
			int age;
			float grade;
			while(true) {
				name = dataInput.readUTF();
				gender = dataInput.readBoolean();
				age = dataInput.readInt();
				grade = dataInput.readFloat();
				
				listStudent.add(new PeopleData(name, gender, age, grade));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		dataInput.close();
		
		return listStudent;
	}
	
	
	public static void main(String[] args) {
		
		String inputFile = "C:/temp/DataInputPeopleData.txt";
		
		try {
			DataInputStreamPeople reader = new DataInputStreamPeople(inputFile);
			
			List<PeopleData> listStudent = reader.readAll();
			
			for(PeopleData student : listStudent) {
				System.out.println(student.getName() + "\t");
				System.out.println(student.getGender() + "\t");
				System.out.println(student.getAge() + "\t");
				System.out.println(student.getGrade() + "\t");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
