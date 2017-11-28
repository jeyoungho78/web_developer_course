package test.aaa;

public class MemberVariable {
	
	int a;
	int b = 100;
	String c;
	String d="변수테스트!!!";
	
	
	public static void main(String[] args) {
		
		MemberVariable ob = new MemberVariable();
		
		System.out.println(ob.a);
		System.out.println(ob.b);
		System.out.println(ob.c);
		System.out.println(ob.d);
		
		int localVariable;
//		System.out.println(localVariable); //에러
	}
	
}
