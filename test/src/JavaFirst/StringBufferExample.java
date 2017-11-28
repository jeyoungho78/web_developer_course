package JavaFirst;

public class StringBufferExample {
	
	public static void main(String[] args) {
		
		StringBuffer sbObj1 = new StringBuffer();
		
		StringBuffer sbObj2 = new StringBuffer(10);
		
		StringBuffer sbObj3 = new StringBuffer("Hello World");
		System.out.println(sbObj3);
		System.out.println("");
		
		sbObj3.append("append String");
		System.out.println(sbObj3);
		System.out.println("");
		
		boolean b = true;
		sbObj3.append(b);
		System.out.println(sbObj3);
		System.out.println("");
		
		char c = 'Y';
		sbObj3.append(c);
		System.out.println(sbObj3);
		System.out.println("");
		
		char[] c1 = new char[] {'Y', 'e', 's'};
		sbObj3.append(c1);
		System.out.println(sbObj3);
		System.out.println("");
		
		double d = 1.0;
		sbObj3.append(d);
		System.out.println(sbObj3);
		System.out.println("");
		
		float f = 1.0f;
		sbObj3.append(f);
		System.out.println(sbObj3);
		System.out.println("");
		
		int i = 1;
		sbObj3.append(i);
		System.out.println(sbObj3);
		System.out.println("");
		
		long l = 1;
		sbObj3.append(i);
		System.out.println(sbObj3);
		
		StringBuffer sb = new StringBuffer("Hello World");
		sb.replace(0, 5, "Hi");
		System.out.println(sb);
		System.out.println(sb.substring(2));
		
		int len = sb.length();
		System.out.println("문자열길이 : " + len);
		
		StringBuffer sb1 = new StringBuffer("Hello World");
		sb1.delete(0, 6);
		System.out.println(sb1);
		
		StringBuffer sb2 = new StringBuffer("Some Content");
		System.out.println(sb2);
		sb2.delete(0, sb2.length());
		System.out.println(sb2);
		
		StringBuffer sb3 = new StringBuffer("Hello World");
		sb3.deleteCharAt(0);
		System.out.println(sb3);
		
	}

}
