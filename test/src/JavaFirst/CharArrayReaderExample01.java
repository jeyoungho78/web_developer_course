package JavaFirst;

import java.io.*;

public class CharArrayReaderExample01 {

	public static void main(String[] args) throws Exception {
		char[] c = { 'H', 'e', 'l', 'l', 'o', '¿Í', 'W', 'o', 'r', 'l', 'd', '³×' };
		CharArrayWriter out = new CharArrayWriter();
		out.write(c);
		
		FileWriter f1 = new FileWriter(new File("C:/temp/CharArrayReaderExample01_01.txt"));
		out.writeTo(f1);
		
		FileWriter f2 = new FileWriter(new File("C:/temp/CharArrayReaderExample01_02.txt"));
		out.writeTo(f2);
		
		f1.close();
		f2.close();
		out.close();
		
		FileWriter f3 = new FileWriter(new File("C:/temp/CharArrayReaderExample01_03.txt"));
		out.writeTo(f3);
		
		System.out.println("Done");
	}

}
