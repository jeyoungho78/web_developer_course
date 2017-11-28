package JavaFirst;

import java.io.File;

public class File11 {

	public static void main(String[] args) {
		String curDir = System.getProperty("user.dir");
		System.out.println("현재디렉트뢰 : "+ curDir + ": Directory");
		
		File[] roots = File.listRoots();
		System.out.println("시스템루트디렉토리:");
		
		for(int i = 0; i < roots.length; i++) {
			System.out.println(roots[i].toString());
		}
		
	}
	
}
