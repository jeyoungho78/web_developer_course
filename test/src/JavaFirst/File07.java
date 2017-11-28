package JavaFirst;

import java.io.File;
import java.text.SimpleDateFormat;

public class File07 {
	public static void main(String[] args) {
		File fl = new File("c:\\Temp\\test.txt");
		System.out.println("Before Format : " + fl.lastModified());
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		System.out.println("After Format : " + sdf.format(fl.lastModified()));
		
		String strParentDirectory = fl.getParent();
		System.out.println("Parent directory : " + strParentDirectory);
	}
}
