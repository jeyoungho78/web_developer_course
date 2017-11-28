package JavaFirst;

import java.io.*;

public class BufferedReaderExapmple01 {
	public static void main(String[] args) {
		
		String thisLine;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("c:/temp/test.txt"));
			
			while((thisLine = br.readLine()) != null) {
				System.out.println(thisLine);
			}
			
		} catch (IOException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
