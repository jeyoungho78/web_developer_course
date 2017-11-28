package JavaFirst;

import java.io.File;
import java.io.IOException;

public class File09 {

	public static void main(String[] args) throws IOException{
		
		File file = new File("C:\\Temp\\test.txt");
		System.out.println("Size: " + file.length() + " bytes");
		System.out.println("파일존재여부: " + file.exists());
		System.out.println("파일절대경로: " + file.getAbsolutePath());
		System.out.println("파일경로: " + file.getPath());
		System.out.println("파일명: " + file.getName());
		
	}
	
}
