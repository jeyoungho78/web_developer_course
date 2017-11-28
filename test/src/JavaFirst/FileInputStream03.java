package JavaFirst;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStream03 {

	public static void main(String[] args) throws IOException {
		File readFile = new File("C:\\Temp\\read.txt");
		File writeFile = new File("C:\\Temp\\write.txt");
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(readFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(writeFile));
		
		byte[] b = new byte[256];
		int n = 0;
		while((n = bis.read(b)) != -1) {
			bos.write(b, 0, n);
			bos.flush();
		}
		
		bis.close();
		bos.close();
		System.out.println("복사완료");
	}
	
}
