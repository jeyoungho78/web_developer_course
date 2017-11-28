package exec.fileio;

import java.io.File;

public class ListSubDirectoryExec {

	public static void main(String[] args) {
		String srcDir = "c:\\temp";
		showFileList(new File(srcDir), 0);
	}

	private static void showFileList(File dir, int level) {
		File[] fileList = dir.listFiles();
		
		try {
			for(int i = 0; i < fileList.length; i++) {
				for (int j = 0; j < level; j++) {
	                System.out.print("\t");
	            }
				
				File file = fileList[i];
				if(file.isDirectory()) {
					System.out.println(file.getName());
					showFileList(file, level + 1);
				} else {
					System.out.println(file.getName());
				}
				//file.delete(); 파일을 삭제한다.
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
