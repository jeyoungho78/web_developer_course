package JavaFirst;

public class OverloadExam {
	void hi() {
		System.out.println("�ȳ�~~");
	}
	
	void hi(String name) {
		System.out.println(name + "�� �ȳ�~~");
	}
	
/*	String hi(String name) {
		return name;
	}*/ //���� �߻� ���ϰ����δ� �Լ� OverLoad �� �� ����.
	
	void hi(String name1, String name2) {
		System.out.println(name1 + "��," + name2 + "�� �ȳ�~~~");
	}
	
	static boolean isSame(int a, int b) {
		System.out.println("int����");
		return a == b;
	}
	
	static boolean isSame(long a, long b) {
		System.out.println("long����");
		return a == b;
	}

	static boolean isSame(float a, float b) {
		System.out.println("float����");
		return a == b;
	}
	static boolean isSame(double a, double b) {
		System.out.println("double����");
		return a == b;
	}
	
	public static void main(String[] args) {
		OverloadExam ob = new OverloadExam();
		ob.hi();
		ob.hi("ö��");
		ob.hi("ö��", "����");
		
		System.out.println(isSame(1, 2));
		//System.out.println(isSame(1L, 2L));
		//System.out.println(isSame(1F, 2F));
		System.out.println(isSame(1.2, 1.2));
	}
}
