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
			// �������� ���� �� ������ üũ 
			File sourceFile = new File(sourceFileName);
			if(!sourceFile.exists()) {
				throw new Exception("Source's file not found!");
			}
			
			String targetDirName = targetFileName.substring(0, targetFileName.lastIndexOf('/'));
			File targetDir = new File(targetDirName);
			if(!targetDir.exists()) {
				throw new Exception("Target's directory not found!");
			}
			
			// ���� ���� ���� 
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
