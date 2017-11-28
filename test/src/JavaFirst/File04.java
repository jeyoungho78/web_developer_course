package JavaFirst;

import java.io.File;

public class File04 {

	public static void main(String[] args) {
		String strFile = "C:" + File.separator + "Temp" + File.separator + "test.txt";
		File file = new File(strFile);
		
		System.out.println(strFile);
		System.out.println(file.isHidden());
	}
	
}
