package JavaFirst;

import java.io.*;

public class PushbackInputStream01 {
	public static void main(String[] args) {
		String srcFile = "c:/temp/read.txt";
		
		try {
			PushbackInputStream pis = new PushbackInputStream(new FileInputStream(srcFile));
			
			byte byteData;
			while((byteData = (byte)pis.read()) != -1) {
				System.out.println((char)byteData);
				pis.unread(byteData);
				
				byteData = (byte)pis.read();
				System.out.println((char)byteData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
