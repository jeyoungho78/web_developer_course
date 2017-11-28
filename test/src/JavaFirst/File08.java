package JavaFirst;

import java.io.File;

public class File08 {
	public static void main(String[] args) {
		File dir = new File("c:\\Temp");
		String[] children = dir.list();
		
		if(children == null) {
			System.out.println("file or directory not found!");
		} else {
			for(int i = 0; i < children.length; i++) {
				String filename = children[i];
				System.out.println(filename);
			}
		}
		
		
	}
}
