package JavaFirst;

import java.io.File;
import java.io.IOException;

public class File02 {

	public static void main(String[] args) throws IOException {

		File file = new File("c:\\temp");
		file.mkdirs();

		if (file.isDirectory()) {
			String[] files = file.list();
			if (files.length > 0) {
				System.out.println("The " + file.getPath() + " is not empty!");
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i]);
				}
			}
		} else {
			System.out.println("디렉토리가 아닙니다.");
		}

	}

}
