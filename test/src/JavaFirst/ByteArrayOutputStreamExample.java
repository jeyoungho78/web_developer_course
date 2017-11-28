package JavaFirst;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamExample {
	
	public static void main(String[] args) throws Exception{
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);
		
		while(bOutput.size() != 10) {
			bOutput.write("hello".getBytes());
		}
		
		byte[] b = bOutput.toByteArray();
		System.out.println("�������");
		
		System.out.println("����:" + b.length);
		for(int x = 0; x < b.length; x++) {
			System.out.println((char)b[x] + "   ");
		}
		System.out.println("   ");
		
		int c;
		ByteArrayInputStream bInput = new ByteArrayInputStream(b);
		
		System.out.println("�빮�ڷ� ����");
		while((c = bInput.read()) != -1) {
			System.out.println(Character.toUpperCase((char)c));
		}
	}

}
