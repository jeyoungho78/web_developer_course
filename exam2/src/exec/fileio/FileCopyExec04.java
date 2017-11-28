package exec.fileio;

import java.io.*;

public class FileCopyExec04 {

	public static void main(String[] args) {
		String sourceFileName = "c:/temp/filereader.txt";
		String targetFileName = "c:/temp/ac/filewriter.txt";
		
		fileCopy(sourceFileName, targetFileName);
	}

	private static void fileCopy(String sourceFileName, String targetFileName) {
		try {
			// 원본파일 유무 및 복사경로 체크 
			File sourceFile = new File(sourceFileName);
			if(!sourceFile.exists()) {
				throw new Exception("Source's file not found!");
			}
			
			String targetDirName = targetFileName.substring(0, targetFileName.lastIndexOf('/'));
			File targetDir = new File(targetDirName);
			if(!targetDir.exists()) {
				throw new Exception("Target's directory not found!");
			}
			
			// 실제 파일 복사 
			FileReader fr = new FileReader(sourceFileName);
			FileWriter fw = new FileWriter(targetFileName);
			
			char[] cbuf = new char[1024];
			int length = 0;
			while((length = fr.read(cbuf)) != -1) {
				fw.write(cbuf, 0, length);
				fw.flush();
			}
			
			fr.close();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fileCopy
	
}
