package JavaFirst;

import java.io.File;

public class File01 {

	public static void main(String[] args) {
		String directories = "c:\\temp\\a\\b\\c\\d";
		File file = new File(directories);
		
		// mkdir : ������� �ϴ� ���丮�� ����� ���丮�� �������� ���� ���, �����Ұ�
		// mkdirs : ������� �ϴ� ���丮�� ���� ���丮�� �������� ���� ���, ��������
		
		boolean result = file.mkdirs();
		System.out.println("Status = " + result);
	}
	
}
