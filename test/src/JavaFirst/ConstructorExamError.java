package JavaFirst;

public class ConstructorExamError {
	
	int a;

	public ConstructorExamError( ) {
		System.out.println("인자가 없는 디폴트 생성자");
	} // ConstructorExamError
	
	public ConstructorExamError(int a) {
		// this();
		this.a = a;
		// this(); // 에러남.... 쓸려면 맨위에 써야됨. 
	}
	
	public static void main(String[] args) {
		ConstructorExamError ob = new ConstructorExamError(2); // 다른 생성자가 있으면 기본 생성자가 생성 안됨
//		생성자를 자동으로 만들어주지 않는다.
//		따라서 만들어 주어야 한다.
	    //System.out.println(ob.a);
	}
	
}
