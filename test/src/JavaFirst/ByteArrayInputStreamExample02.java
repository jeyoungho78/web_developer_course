package JavaFirst;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamExample02 {
	public static void main(String[] args) {
		String str = "Hello World! \nByteArrayInputStream Test Program.";
		InputStream is = null;
		
		try {
			byte[] buff = str.getBytes();
			is = new ByteArrayInputStream(buff);
			
			while(is.available() != 0) {
				System.out.println(new Character((char)is.read()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
