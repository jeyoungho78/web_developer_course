package JavaFirst;

import java.io.*;

public class CharArrayReaderExample03 {
	
	public static void main(String[] args) {
	
		CharArrayWriter charArrayWriter = new CharArrayWriter();
		
		try {
			charArrayWriter.write("�̹��� CharArrayReaderExample03 �����Դϴ�.");
			
			char[] ch = charArrayWriter.toCharArray();
			
			for(char c : ch) {
				System.out.print(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
