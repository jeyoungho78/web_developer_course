package JavaFirst;

public class OverloadExam {
	void hi() {
		System.out.println("¾È³ç~~");
	}
	
	void hi(String name) {
		System.out.println(name + "¾¾ ¾È³ç~~");
	}
	
/*	String hi(String name) {
		return name;
	}*/ //¿¡·¯ ¹ß»ý ¸®ÅÏ°ªÀ¸·Î´Â ÇÔ¼ö OverLoad ÇÒ ¼ö ¾ø´Ù.
	
	void hi(String name1, String name2) {
		System.out.println(name1 + "¾¾," + name2 + "¾¾ ¾È³ç~~~");
	}
	
	static boolean isSame(int a, int b) {
		System.out.println("int½ÇÇà");
		return a == b;
	}
	
	static boolean isSame(long a, long b) {
		System.out.println("long½ÇÇà");
		return a == b;
	}

	static boolean isSame(float a, float b) {
		System.out.println("float½ÇÇà");
		return a == b;
	}
	static boolean isSame(double a, double b) {
		System.out.println("double½ÇÇà");
		return a == b;
	}
	
	public static void main(String[] args) {
		OverloadExam ob = new OverloadExam();
		ob.hi();
		ob.hi("Ã¶¼ö");
		ob.hi("Ã¶¼ö", "¿µÈñ");
		
		System.out.println(isSame(1, 2));
		//System.out.println(isSame(1L, 2L));
		//System.out.println(isSame(1F, 2F));
		System.out.println(isSame(1.2, 1.2));
	}
}
