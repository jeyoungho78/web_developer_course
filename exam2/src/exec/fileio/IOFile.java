package exec.fileio;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOFile {
	public static void main(String[] args) throws IOException {
//		FileOutputStream output = new FileOutputStream("C:/temp/out.txt");
//		
//		for(int i = 1; i < 11; i++) {
//			String data = i + " 번째 줄입니다.\r\n";
//			output.write(data.getBytes());
//		}
//		
//		output.close();
		
//		FileWriter fw = new FileWriter("C:/temp/out.txt");
//		
//		for(int i = 1; i < 11; i++) {
//			String data = i + " 번째 줄입니다.\r\n";
//			fw.write(data);
//		}
//		
//		fw.close();

		PrintWriter pw = new PrintWriter("C:/temp/out.txt");
		
		for(int i = 1; i < 11; i++) {
			String data = i + " 번째 줄입니다.\r\n";
			pw.print(data);
		}
		
		pw.close();
		
//		FileWriter fw = new FileWriter("C:/temp/out.txt", true);
//		
//		for(int i = 1; i < 21; i++) {
//			String data = i + " 번째 줄입니다.\r\n";
//			fw.write(data);
//		}
//		
//		fw.close();
		
		
	}
}
