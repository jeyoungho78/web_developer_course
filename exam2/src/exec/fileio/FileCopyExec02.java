package exec.fileio;

import java.io.*;
import java.util.Scanner;

public class FileCopyExec02 {
	
	public static void main(String[] args) {
		String source = "C:/Temp/read.txt";
		String target = "c:/Temp/ar/write.txt";
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Input source file : ");
//		System.out.println("=>" + (source = sc.next()));
//		
//		System.out.println("Input target file : ");
//		System.out.println("=>" + (target = sc.next()));
		
		FileCopy(source, target);
		
	}// main

	/**
	 *
	 * @Method Name : FileCopy
	 * @param source
	 * @param target
	 */
	private static void FileCopy(String source, String target){
		File sourceFile = new File(source);
		File targetFile = new File(target);
	
		if(!CheckFile(source, target)) {
			return;
		}
		
		BufferedInputStream bis = null;
		PrintStream ps = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(sourceFile));
			ps = new PrintStream(targetFile);
			
			byte[] data = new byte[1024];
			int size = 0;
			while((size = bis.read(data)) != -1) {
				ps.write(data, 0, size);
				ps.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// FileCopy

	/**
	 *
	 * @Method Name : CheckFile
	 * @param source
	 * @param target
	 * @return
	 */
	private static boolean CheckFile(String source, String target) {
		File sourceFile = new File(source);
		File targetFile = new File(target);
		
		if(!sourceFile.exists()) {
			System.out.println("Sourcefile is not found!!");
			return false;
		}
		
		int endIndex = -1;
		String strDir = "";
		
		endIndex = target.lastIndexOf('/');
		strDir = target.substring(0, endIndex);
		
		File dir = new File(strDir);
		
		if(!dir.exists()) {
			System.out.println("Targetfile's Directory is not found!!");
			return false;
		}
		
		// 저장 폴더의 상위 경로부터 하나하나 체크
		/*int fromIndex = -1;
		String strDir = "";
		for(int i=0; i < target.length(); i++) {
			fromIndex = target.indexOf('/', fromIndex + 1);
			if(fromIndex == -1) {
				break;
			}
			
			strDir = target.substring(0, fromIndex);
			File dir = new File(strDir);
			if(!dir.exists()) {
				System.out.println("Targetfile's Directory is not found!!");
				return false;
			}
		}*/
		
		return true;
	}//CheckFile

}//FileCopyExec
