package JavaFirst;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class BufferedInputStreamExample01 {
	public static void main(String[] args) {
		int idata = -1;
		InputStream is = (System.in);
		System.out.println("키보드에서 문자입력[마지막에 엔터]");
		System.out.println("-----------------------------");

		try {

			BufferedInputStream bis = new BufferedInputStream(is);
			
			while (true) {
				idata = bis.read();

				if (idata == -1 || (char) idata == 'x') {
					break;
				}
				
				System.out.println((char)idata);
				//System.out.println(":" + idata);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
	
}
