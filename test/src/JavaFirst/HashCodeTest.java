package JavaFirst;

public class HashCodeTest {

	public static void main(String[] args) {
		
		String ob1 = new String("abc");
		String ob2 = ob1; // ob2�� ob1�� ��ü�� �����Ѵ�. 
		String ob3 = ob2; // ob3�� ob2�� ��ü�� �����Ѵ�. 
		
		// ob1==ob2==ob3
		
		System.out.println("ob1�� �ؽ��ڵ� : " + ob1.toString());
		System.out.println("ob2�� �ؽ��ڵ� : " + ob2.hashCode());
		System.out.println("ob3�� �ؽ��ڵ� : " + ob3.hashCode());
		
		
	}//main
}//class
