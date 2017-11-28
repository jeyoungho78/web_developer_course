package exec.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamExec {
	
	public static void main(String[] args) throws IOException {
		
		String temp = "abcdefg";
		byte[] buff = temp.getBytes();
		
		InputStream is = new ByteArrayInputStream(buff);
		BufferedInputStream bis = new BufferedInputStream(is);
		
		int idata = -1;
		while ((idata = bis.read()) != -1) {			
			System.out.println((char)idata);
		}
		
		bis.close();
		is.close();
		
	}
	

}
