package exec.fileio;

import java.io.*;

public class FileCopyExec03 {
	
	public static void main(String[] args) {
		String sourceFileName = "c:/temp/source.txt";
		String targetFileName = "c:/temp/ab/copy_source.txt";
		
		fileCopy(sourceFileName, targetFileName);
		
	}

	private static void fileCopy(String sourceFileName, String targetFileName) {
		try {
			File sourceFile = new File(sourceFileName);
			File targetFile = new File(targetFileName);
			
			if(!sourceFile.exists()) {
				throw new Exception("���� ������ �������� �ʽ��ϴ�.");
			}
			
			String targetDirName = targetFileName.substring(0, targetFileName.lastIndexOf('/'));
			File targetDir = new File(targetDirName);
			if(!targetDir.exists()){
				throw new Exception("���� ������ ���丮�� �������� �ʽ��ϴ�.");
			}
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = bis.read(buf)) != -1) {
				bos.write(buf, 0, size);
				bos.flush();
			}
			
			bis.close();
			bos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
