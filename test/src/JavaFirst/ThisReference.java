package JavaFirst;

public class ThisReference {

	int a;
	long myLong;
	
	void setA(int a) {
		this.a = a;
	}
	
	int getA() {
		//int a = 200;
		return a; // �������� a�� �����Ƿ� ���⼭ a�� this.a�� ���Ѵ�.
	}
	
	void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	
	long getMyLong() {
		return myLong;
	}
	
	public static void main(String[] args) {
		
		ThisReference ob = new ThisReference();
		ob.setA(1000);
				
		System.out.println(ob.a);
		System.out.println(ob.getA());	
	}
}
