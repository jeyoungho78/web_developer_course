package JavaCall;

/*
 * - interface�� ��� ��� ������ static�̰� final�̴�.
 * - ��� �޼ҵ�� �߻� �޼ҵ��̴�. 
 * - �������̽��� ��� �޼��尡 �߻��̹Ƿ� �������̽��� ����ϴ� Ŭ������ 
 * 	       ��� �߻� �޼ҵ带 �������̵� �ؾ߸� ��ü�� �� �� �ִ�.
 * - ���߱��� ����
 * - interface�� �޼ҵ�� private �Ǵ� protected
 *   (interface�� �ڽ� Ŭ������ �����Ƿ�) ������ �Ұ�
 */

public interface HumanInter {
	public static final int MAX = 100;
	public int MIN = 1;
	public abstract void method1();
	public void method2(int a);
}
