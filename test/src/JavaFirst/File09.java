package JavaFirst;

import java.io.File;
import java.io.IOException;

public class File09 {

	public static void main(String[] args) throws IOException{
		
		File file = new File("C:\\Temp\\test.txt");
		System.out.println("Size: " + file.length() + " bytes");
		System.out.println("�������翩��: " + file.exists());
		System.out.println("����������: " + file.getAbsolutePath());
		System.out.println("���ϰ��: " + file.getPath());
		System.out.println("���ϸ�: " + file.getName());
		
	}
	
}
