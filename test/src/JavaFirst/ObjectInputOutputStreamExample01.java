package JavaFirst;

import java.io.*;

public class ObjectInputOutputStreamExample01 {
	public static void main(String[] args) {
		String s = "Hello world!";
		int i = 897648764;
		
		try {
			FileOutputStream out = new FileOutputStream("c:/temp/ObjectInputStreamExample01.txt");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			
			oos.writeObject(s);
			oos.writeObject(i);
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/temp/ObjectInputStreamExample01.txt"));
			System.out.println("" + (String)ois.readObject());
			System.out.println("" + ois.readObject());
			ois.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
