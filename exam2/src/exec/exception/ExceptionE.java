package exec.exception;

import java.io.IOException;

public class ExceptionE {
	
	void throwArithmeticException() {
		throw new ArithmeticException();
	}

	void throwIOException1() {
		try {
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void throwIOException2() throws IOException{
		throw new IOException();
	}
}
