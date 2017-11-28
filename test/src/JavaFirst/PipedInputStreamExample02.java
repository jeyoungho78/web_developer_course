package JavaFirst;

import java.io.*;

public class PipedInputStreamExample02 extends PipedInputStream {

	public static void main(String[] args) throws Exception {

		PipedOutputStream out = new PipedOutputStream();
		PipedInputStreamExample02 in = new PipedInputStreamExample02();

		in.connect(out);

		System.out.println("최초:" + in.available());

		out.write(70);
		out.write(71);

		System.out.println("receive 전:" + in.available());

		in.receive(73);
		System.out.println("receive 후:" + in.available());

		for (int i = 0; i < 3; i++) {
			System.out.println("" + (char)in.read());
		}
		
		in.close();
	}

}
