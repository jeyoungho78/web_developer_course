package JavaFirst;

import java.io.*;

public class PrintStreamExample01 {

	public static void main(String[] args) {
		PrintStream psConsole = new PrintStream(System.out);
		try {
			psConsole.write("Data�� PrintStream�� ����ؼ� �������� �ֽ��ϴ�.".getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
		psConsole.flush();
		psConsole.close();
		
		PrintStream pwFile = null;
		try {
			pwFile = new PrintStream(new File("c:/temp/text.txt"));
			pwFile.write("Data�� PrintStream�� ����ؼ� �������� �ֽ��ϴ�.".getBytes());
			pwFile.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			pwFile.close();
		}
	}//main
}//class
