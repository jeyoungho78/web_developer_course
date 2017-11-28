package JavaFirst;

import java.io.*;

public class CharArrayReaderExample03 {
	
	public static void main(String[] args) {
	
		CharArrayWriter charArrayWriter = new CharArrayWriter();
		
		try {
			charArrayWriter.write("이번은 CharArrayReaderExample03 예제입니다.");
			
			char[] ch = charArrayWriter.toCharArray();
			
			for(char c : ch) {
				System.out.print(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
