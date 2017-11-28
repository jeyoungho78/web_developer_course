package JavaFirst;

import java.io.File;

public class File01_01 {

	public static void main(String[] args) throws Exception{
		String directories = "c:\\temp\\a\\b\\c\\d";
		File file = new File(directories);
		
		boolean result = file.delete();
		System.out.println("Status = " + result);
	}
}
