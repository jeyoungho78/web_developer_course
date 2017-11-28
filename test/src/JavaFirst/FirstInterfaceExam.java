package JavaFirst;

import JavaCall.MyInter;

public class FirstInterfaceExam implements MyInter {

	public void method1() {
		System.out.println("Method1 Override!");
	}

	public void method2(int a) {
		System.out.println(a + " : Method2 Override!");
	}
	
	public static void main(String[] args) {
		FirstInterfaceExam ob = new FirstInterfaceExam();
		ob.method1();
		ob.method2(123);
		
		System.out.println(FirstInterfaceExam.MAX); // 
		System.out.println(MyInter.MIN); // static 변수는 객체 없이도 사용 가능
	}
	
}
