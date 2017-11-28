package JavaFirst;

public class ThisReference {

	int a;
	long myLong;
	
	void setA(int a) {
		this.a = a;
	}
	
	int getA() {
		//int a = 200;
		return a; // 지역변수 a가 없으므로 여기서 a는 this.a를 말한다.
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
