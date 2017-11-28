package exec.io;

import java.io.*;
import java.util.*;

import data.io.PeopleData;

public class DataOutputStreamPeople {
	DataOutputStream dataOutput;
	
	public DataOutputStreamPeople(String outputFile) throws IOException {
		dataOutput = new DataOutputStream(new FileOutputStream(outputFile));
	}
	
	public void write(PeopleData student) throws IOException {
		dataOutput.writeUTF(student.getName());
		dataOutput.writeBoolean(student.getGender());
		dataOutput.writeInt(student.getAge());
		dataOutput.writeFloat(student.getGrade());
	}
	
	public void save() throws IOException {
		dataOutput.close();
	}
	
	public static void main(String[] args) {
		String outputFile = "c:/Temp/DataInputPeopleData.txt";
		
		List<PeopleData> listPeopleData = new ArrayList<PeopleData>();
		
		listPeopleData.add(new PeopleData("Alice", false, 23, 80.5f));
		listPeopleData.add(new PeopleData("Brian", true, 22, 95.0f));
		listPeopleData.add(new PeopleData("ȫ�浿", false, 21, 79.8f));
		
		try {
			DataOutputStreamPeople writer = new DataOutputStreamPeople(outputFile);
			
			for(PeopleData people : listPeopleData) {
				writer.write(people);
			}
			
			writer.save();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
