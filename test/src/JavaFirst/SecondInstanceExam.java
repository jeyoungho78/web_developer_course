package JavaFirst;

import JavaCall.MyClass;
import JavaCall.SecondMyInter1;
import JavaCall.SecondMyInter2;

// SecondInstanceExam MyClass�� ����ϰ� SecondMyInter1�� SecondMyInter2�� �����Ѵ�.  
public class SecondInstanceExam extends MyClass implements SecondMyInter1, SecondMyInter2{

	public void method1() { // ����
		System.out.println("Method1 Override");
	}
	
	public void method2() { // ����
		System.out.println("Method2 Override");
	}
	
	public static void main(String[] args) {
		SecondInstanceExam ob = new SecondInstanceExam();
		ob.method1();
		ob.method2();
		ob.hi();
	}
	
}
