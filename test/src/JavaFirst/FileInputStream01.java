package JavaFirst;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream01 {
	public static void main(String[] args) {
		File file = new File("C:/temp/test.txt");
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

			System.out.println("bytes size : " + fis.available());

			int content;
			while ((content = fis.read()) != -1) {
				System.out.print((char) content);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
