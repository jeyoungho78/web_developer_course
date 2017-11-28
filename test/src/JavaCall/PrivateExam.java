package JavaCall;

import JavaFirst.PrivateClass;

public class PrivateExam {
	public static void main(String[] args) {
		
		PrivateClass ob = new PrivateClass();
		
		//ob.num = 10; // Error
		//ob.callPrivate(); // Error
		
		ob.call();
	}
}
