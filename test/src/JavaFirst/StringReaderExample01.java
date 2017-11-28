package JavaFirst;

import java.io.*;

public class StringReaderExample01 {

	public static void main(String[] args) {
		String str = "안녕하세요! This is StringReader Program 테스트 입니다.";
		StringReader sr = new StringReader(str);
		int i = 0;
		int loop = 1;
		System.out.println("sr.markSupported()" + sr.markSupported());
		try {
			while ((i = sr.read()) != -1) {
				System.out.print((char) i);

				if (loop == 2) {
					sr.mark(4);
				} else if (loop == 5) {
					sr.mark(7); 
				}

				loop += 1;
			}

			System.out.println("\n=================================");
			sr.reset(); // 마지막 mark에서부터 reset됨
			char[] charBuf = new char[10];
			int readLength = 0;
			StringWriter sw = new StringWriter();
			while ((readLength = sr.read(charBuf)) != -1) {
				sw.write(charBuf, 0, readLength);
				sw.flush();
			}

			System.out.println(sw.toString());

			sr.close();
			sw.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
