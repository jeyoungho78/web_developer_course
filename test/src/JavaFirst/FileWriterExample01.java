package JavaFirst;

import java.io.*;

public class FileWriterExample01 {
	
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("c:\\Temp\\filewriter01.txt");
			fw.write("FileWriter 예제.");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("FileWriter를 이용한 쓰기성공");
	}

}
