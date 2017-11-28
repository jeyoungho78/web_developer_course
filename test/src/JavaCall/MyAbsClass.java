package JavaCall;

public abstract class MyAbsClass {
	// 추상 메소드를 포함하는 클래스
	// 객체로 생성할 수 없다
	// abstract 메소드는 private 또는 static이 될 수 없다
	// (static 메소드는 겍체 없이도 호출되는 메소드이므로 body에 정의되어야 한다.)
	
	int myInt;
	public abstract void noAction(); // 추상 메소드
	
	public int getMyInt() {          // 비 추상 메소드 
		return myInt;
	}
	
}
