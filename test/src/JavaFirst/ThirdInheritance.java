package JavaFirst;

class ThirdParent{
	
	int a;
	
	ThirdParent() {
		a = 1;
	}
	
	ThirdParent(int a){
		this.a = a;
	}
	
	
}

public class ThirdInheritance extends ThirdParent {

	int b;
	ThirdInheritance(int a, int b) {
		super(a); // super의 위치는 제일 처음에 위치해야 한다. 
		this.b = b;
	}
	
	public static void main(String[] args) {
		
		ThirdInheritance ob = new ThirdInheritance(10, 20);
		System.out.println(ob.a + " " + ob.b);
		
	}
}
