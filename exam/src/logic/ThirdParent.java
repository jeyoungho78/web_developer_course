package logic;

public class ThirdParent {

	protected int a;
	
	ThirdParent() {
		a = 1;
	}
	
	//protected: package가 상이할시에도 상속시 자식클래스에서 접근가능한 접근지정자
	protected ThirdParent(int a){
		this.a = a;
	}
	
}
