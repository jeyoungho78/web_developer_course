package JavaFirst;

public class PassByReference3 {
	
	public static void main(String[] args) {
		
		PassByReference2 ob = new PassByReference2(100);
		PassByReference2 ob2 = new PassByReference2(300);
		
		ob.twice(ob);
		ob2.twice(ob);
		
		System.out.println("ob : " + ob.getA());
		System.out.println("ob2 : " + ob2.getA());
		System.out.println("ob : " + ob.getA());
		
		ob.play(new String("Ã¶¼ö"));
		
	}
	
}
