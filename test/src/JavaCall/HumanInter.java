package JavaCall;

/*
 * - interface의 모든 멤버 변수는 static이고 final이다.
 * - 모든 메소드는 추상 메소드이다. 
 * - 인터페이스의 모든 메서드가 추상이므로 인터페이스를 상속하는 클래스는 
 * 	       모든 추상 메소드를 오버라이드 해야만 객체가 될 수 있다.
 * - 다중구현 가능
 * - interface의 메소드는 private 또는 protected
 *   (interface는 자식 클래스가 없으므로) 접근자 불가
 */

public interface HumanInter {
	public static final int MAX = 100;
	public int MIN = 1;
	public abstract void method1();
	public void method2(int a);
}
