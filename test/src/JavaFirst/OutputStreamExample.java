package JavaFirst;

import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamExample{
	public static void main(String[] args)  throws Exception {
		System.out.println("���ڸ� �Է��ϰ� [����] ġ����");
		InputStream is = (System.in);
		
		System.out.println("�Է��� ���� : ");
		int a = is.read();
		
		System.out.println("��� ��Ʈ�� : ");
		OutputStream os = (System.out);
		
		os.write(a);
		os.flush();
		
		System.out.println("");
		System.out.println("����Ʈ �迭 ��� ��Ʈ�� ���");
		
		byte[] osByte = "12345�ȳ�".getBytes();
		os.write(osByte);
		os.flush();
		
		is.close();
		os.close();
		
	}
}
