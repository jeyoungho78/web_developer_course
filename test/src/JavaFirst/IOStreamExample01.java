package JavaFirst;

import java.io.InputStream;

public class IOStreamExample01 {
	public static void main(String[] args) {

		int idata = -1;
		InputStream is = (System.in);
		System.out.println("키보드에서 문자입력[마지막에 엔터]");
		System.out.println("-----------------------------");

		try {
			byte[] data = new byte[10];
			while (true) {
				is.skip(1);
				idata = is.read(data, 0, 2);

				if (idata == -1 || (char) idata == 'x') {
					break;
				}
				
				//System.out.println((char)idata);
				//System.out.println(":" + idata);
				System.out.println(":" + (char)data[0]);
				System.out.println(":" + (char)data[1]);
				//System.out.println(":" + (char)data[2]);
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
