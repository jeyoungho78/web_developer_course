package JavaFirst;

import java.io.*;

public class PushbackInputStream02 {

	public static void main(String[] args) {
		try {
			String s = "Java.";
			System.out.println(s);

			byte[] buffer = s.getBytes();
			ByteArrayInputStream in = new ByteArrayInputStream(buffer);
			PushbackInputStream f = new PushbackInputStream(in);

			int c;
			while ((c = f.read()) != -1) {
				switch (c) {
				case 'a':
					if((c = f.read()) == 'v') {
						System.out.print("o");
					} else {
						System.out.print("b");
						f.unread(c);
					}
					break;
				default:
					System.out.print((char)c);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
