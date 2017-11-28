package JavaFirst;

import JavaCall.Sub;
import JavaCall.Super;

public class ReferenceScope {
	
	public static void main(String[] args) {
		Super ob = new Sub();
		// 부모클래스 변수  = 자식클래스정보
		
		ob.a = 20;
		ob.hi(); // 자식의 hi()가 실행된다.
		//ob.b = 30; // -> 에러, 참조불가
		//ob.bye();  // -> 에러, 참조불가
	
	}
	
}
