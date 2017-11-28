package JavaFirst;

import java.io.*;

public class CharArrayReaderExample02 {
	
	public static void main(String[] args) throws Exception {
		CharArrayWriter caw = new CharArrayWriter();
		
		String s = "�̰��� char �迭�Դϴ�.";
		char[] buf = new char[s.length()];
		s.getChars(0, s.length(), buf, 0);
		caw.write(buf);
		
		System.out.println(caw.toString());
		
		char[] c = caw.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
		System.out.println("\\n FileWriter()�� �̿��� ��������");
		
		FileWriter f2 = new FileWriter("c:/temp/CharArrayReaderExample02.txt");
		caw.writeTo(f2);
		f2.close();
		
		System.out.println("reset�� :" + caw.toString() + "\t ������:" + caw.size());
		
		caw.reset();
		
		for (int i = 0; i < 3; i++) {
			caw.write('X');
		}
		
		System.out.println("reset�� :" + caw.toString() + "\t ������:" + caw.size());
	}
	
}
