package JavaFirst;

import java.io.File;

public class File11 {

	public static void main(String[] args) {
		String curDir = System.getProperty("user.dir");
		System.out.println("�����Ʈ�� : "+ curDir + ": Directory");
		
		File[] roots = File.listRoots();
		System.out.println("�ý��۷�Ʈ���丮:");
		
		for(int i = 0; i < roots.length; i++) {
			System.out.println(roots[i].toString());
		}
		
	}
	
}
