package exec.io;

import java.io.*;
import java.util.*;

import data.io.HousePeopleData;

public class DataInputStreamHousePeople {
	DataInputStream dataInput;

	public DataInputStreamHousePeople(String inputFile) throws IOException {
		this.dataInput = new DataInputStream(new FileInputStream(inputFile));
	}

	private List<HousePeopleData> readAll() throws IOException {
		List<HousePeopleData> listHousePeople = new ArrayList<HousePeopleData>();

		try {
			String name;
			int age;
			boolean houseHolder;
			while (dataInput.available() > 0) {
				name = dataInput.readUTF();
				age = dataInput.readInt();
				houseHolder = dataInput.readBoolean();

				listHousePeople.add(new HousePeopleData(name, age, houseHolder));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dataInput.close();
		
		return listHousePeople;
	}

	public static void main(String[] args) {
		String inputFile = "c:/temp/DataOutputStreamHousePeople.txt";

		try {
			DataInputStreamHousePeople dishp = new DataInputStreamHousePeople(inputFile);

			List<HousePeopleData> listHousePeople = dishp.readAll();
			
			for(HousePeopleData housePeople : listHousePeople) {
				System.out.print(housePeople.getName() + "\t");
				System.out.print(housePeople.getAge() + "\t");
				System.out.print(housePeople.isHouseholder() + "\t");
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
