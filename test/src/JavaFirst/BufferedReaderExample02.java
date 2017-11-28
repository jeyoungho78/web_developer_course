package JavaFirst;

import java.io.*;

public class BufferedReaderExample02 {
	
	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("c:/temp/test.txt");
		BufferedReader br = new BufferedReader(fr);
		
		OutputStreamWriter writer = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(writer);
		
		int length;
		char[] cbuf = new char[256];
		while((length = br.read(cbuf)) != -1) {
			bw.write(cbuf, 0, length);
			bw.flush();
		}
		
		fr.close();
		br.close();
		writer.close();
		bw.close();
	}
	
	
}
