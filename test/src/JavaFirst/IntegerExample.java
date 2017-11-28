package JavaFirst;

public class IntegerExample {
	
	public static void main(String[] args) {
		
		int i = 10;
		Integer intg = new Integer(i);
		System.out.println(intg);
		
		String no = "223";
		Integer num = new Integer(no);
		System.out.println(num);
		
		int x = Integer.valueOf("200");
		System.out.println(x);
		
		int xx = Integer.valueOf("300");
		System.out.println(xx);
		
		Integer itr = new Integer(10);
		System.out.println("byte value : " + itr.byteValue());
		System.out.println("double value : " + itr.doubleValue());
		System.out.println("float value : " + itr.floatValue());
		System.out.println("int value : " + itr.intValue());
		System.out.println("int value : " + itr.valueOf(itr));
		System.out.println("long value : " + itr.longValue());
		System.out.println("short value : " + itr.shortValue());
		
	}
	
	
}
