package exec.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class B {
	void run() throws IOException, FileNotFoundException {
		BufferedReader bReader = null;
		String input = null;
		bReader = new BufferedReader(new FileReader("out.txt"));
		input = bReader.readLine();
		System.out.println(input);
	}
}

class C {
	void run() throws IOException, FileNotFoundException {
		B b = new B();
		b.run();

		// try {
		// b.run();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}
}

public class ThrowExceptionDemo {

	public static void main(String[] args) {
		C c = new C();
		try {
			c.run();
		} catch (FileNotFoundException e) {
			System.out.println("out.txt ������ ���� ���� �Դϴ�. �� ������ ������Ʈ ��Ʈ ���丮�� �����ؾ� �մϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
