package JavaFirst;

public class HashCodeTest {

	public static void main(String[] args) {
		
		String ob1 = new String("abc");
		String ob2 = ob1; // ob2는 ob1의 객체를 참조한다. 
		String ob3 = ob2; // ob3는 ob2의 객체를 참조한다. 
		
		// ob1==ob2==ob3
		
		System.out.println("ob1의 해시코드 : " + ob1.toString());
		System.out.println("ob2의 해시코드 : " + ob2.hashCode());
		System.out.println("ob3의 해시코드 : " + ob3.hashCode());
		
		
	}//main
}//class
