package exec.io;

import java.io.*;
import java.util.*;

import data.io.HousePeopleData;

public class DataOutputStreamHousePeople {
	DataOutputStream dataOutput;
	
	public DataOutputStreamHousePeople(String outputFile) throws IOException {
		this.dataOutput = new DataOutputStream(new FileOutputStream(outputFile)); 
	}
	
	private void write(HousePeopleData housePeople) throws IOException {
		dataOutput.writeUTF(housePeople.getName());
		dataOutput.writeInt(housePeople.getAge());
		dataOutput.writeBoolean(housePeople.isHouseholder());
		dataOutput.flush();
	}
	
	private void save() throws IOException {
		dataOutput.close();
	}
	
	public static void main(String[] args) {
		String outputFile = "c:/temp/DataOutputStreamHousePeople.txt";
		
		List<HousePeopleData> listHousePeople = new ArrayList<HousePeopleData>();
		listHousePeople.add(new HousePeopleData("Mike", 43, true));
		listHousePeople.add(new HousePeopleData("Tom", 37, true));
		listHousePeople.add(new HousePeopleData("Alice", 51, true));
		
		try {
			DataOutputStreamHousePeople doshp = new DataOutputStreamHousePeople(outputFile);
			
			for(HousePeopleData housePeople : listHousePeople) {
				doshp.write(housePeople);
			}
			
			doshp.save();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	
	
}
