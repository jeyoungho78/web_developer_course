package exec.fileio;

import java.io.*;

public class FileCopyExec05 {

	public static void main(String[] args) {
		String sourceFileName = "c:/temp/source.txt";
		String targetFileName = "c:/temp/ad/copy_source.txt";

		fileCopy(sourceFileName, targetFileName);
	}

	private static void fileCopy(String sourceFileName, String targetFileName) {

		try {
		/*	// 원본파일 유무 및 복사경로 체크
			File sourceFile = new File(sourceFileName);
			if (!sourceFile.exists()) {
				throw new Exception("Source's file not found!");
			}

			String targetDirName = targetFileName.substring(0, targetFileName.lastIndexOf('/'));
			File targetDir = new File(targetDirName);
			if (!targetDir.exists()) {
				throw new Exception("Target's directory not found!");
			}*/

			// 실제 파일 복사
			FileReader fr = new FileReader(sourceFileName);
			FileWriter fw = new FileWriter(targetFileName);

			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);

			String thisLine = null;
			char[] cbuf = new char[1024];
			int length = 0;
			while ((thisLine = br.readLine()) != null) {
				cbuf = thisLine.toCharArray();
				length = cbuf.length;

				bw.write(cbuf, 0, length);
				bw.newLine();
				bw.flush();
			}

			br.close();
			bw.close();

			fr.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
