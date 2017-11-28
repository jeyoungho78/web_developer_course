package JavaFirst;

import java.io.*;

public class FileReaderExample01 {

	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("c:/temp/read.txt");
		OutputStreamWriter writer = new OutputStreamWriter(System.out);
		int length;
		char[] cbuf = new char[256];
		while((length = fr.read(cbuf)) != -1) {
			writer.write(cbuf, 0, length);
			writer.flush();
		}
		fr.close();
		writer.close();
	}
}
