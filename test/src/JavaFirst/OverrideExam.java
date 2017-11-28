package JavaFirst;

import JavaCall.OverrideParent;

public class OverrideExam extends OverrideParent{
	int a = 20; // 오버리아드
	void f( ) {
		System.out.println(super.a); // 부모로부터 물려받은 멤버
		System.out.println(this.a);  // 자식이 다시 정의한 멤버
		System.out.println(a); // 자신의 멤버 
	}
	
	public void hello() { // 오버라이드
		super.hello(); // 상속 받은 hello() 호출
		System.out.println("Son hello()"); // 기능 확장
	}
	
	public static void main(String[] args) {
		OverrideExam ob = new OverrideExam();
		ob.f();
		ob.hello();
	}
}
