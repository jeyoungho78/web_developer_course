package JavaFirst;

import java.io.File;

public class File01 {

	public static void main(String[] args) {
		String directories = "c:\\temp\\a\\b\\c\\d";
		File file = new File(directories);
		
		// mkdir : 만들고자 하는 디렉토리의 사우이 디렉토리가 존재하지 않을 경우, 생성불가
		// mkdirs : 만들고자 하는 디렉토리의 상위 디렉토리가 존재하지 않을 경우, 생성가능
		
		boolean result = file.mkdirs();
		System.out.println("Status = " + result);
	}
	
}
