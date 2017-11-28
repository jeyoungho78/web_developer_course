package JavaFirst;

import JavaCall.EqualOverriding;

public class EqualOverridingTest {

	public static void main(String[] args) {
		
		EqualOverriding ob1 = new EqualOverriding("abc");
		EqualOverriding ob2 = new EqualOverriding("abd");
		//ob1.setA(1);
		//ob2.setA(1);
		
		System.out.println(ob1.equals(ob2));
		
	}
	
}
