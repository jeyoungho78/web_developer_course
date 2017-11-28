package exec.string;

public class StringFuncExam {
	
	public static void main(String[] args) {
		
		String str = "I like cooking!!";
		String str1 = "I Like Cooking!!";
		
		System.out.println(str.length());
		
		System.out.println(str.charAt(0));
		
		System.out.println(str.equalsIgnoreCase(str1));
		
		System.out.println(str.startsWith("I"));
		
		System.out.println(str.endsWith("!!"));
		
		System.out.println(str.indexOf('l'));
		
		System.out.println(str.indexOf('i', 5));
		
		System.out.println(str.lastIndexOf('i'));
		
		System.out.println(str.lastIndexOf('i', 5));
		
		System.out.println(str.indexOf("ki"));
		
		System.out.println(str.indexOf("ki", 5));
		
		System.out.println(str.lastIndexOf("ki"));
		
		System.out.println(str.lastIndexOf("ki", 16));
		
		System.out.println(str.substring(5));
		
		System.out.println(str.substring(2, 8));
		
		System.out.println(str.concat(" I want to go to ").concat("preschool !!"));
		
		System.out.println(str.replace("cooking", "fishing"));
		
		System.out.println(str.toLowerCase());
		
		System.out.println(str.toUpperCase());
		
	}
	

}
