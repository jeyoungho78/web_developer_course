package JavaFirst;

import JavaCall.SubCast;
import JavaCall.SuperCast;

public class ObjectCast {
	
	public static void main(String[] args) {
		SuperCast ob1 = new SubCast();
		SubCast ob2 = (SubCast)ob1;
		
		ob1.hi();
		ob2.hi();
		ob2.bye(); // obl은 bye()를 호출할 수 없다. 
		
	}
	
}
