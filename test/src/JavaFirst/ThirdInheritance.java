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
		super(a); // super�� ��ġ�� ���� ó���� ��ġ�ؾ� �Ѵ�. 
		this.b = b;
	}
	
	public static void main(String[] args) {
		
		ThirdInheritance ob = new ThirdInheritance(10, 20);
		System.out.println(ob.a + " " + ob.b);
		
	}
}
