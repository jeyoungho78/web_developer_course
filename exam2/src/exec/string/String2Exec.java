package exec.string;

import logic.string.String2;

public class String2Exec {
	
	public static void main(String[] args) {
		String2 str = new String2("abcdef");
		
		System.out.println(str.subString(2, 4));
		
		System.out.println(str.subString("java!!", 2, 4));
		
		System.out.println(str.countSearch("java!!", 'a'));
		
		System.out.println(str.countSearch("ab!cde!12!45!1!", '!'));
		
		System.out.println(str.countSearch2("ab!cde!12!45!1!", "!"));
		
		System.out.println(str.countSearch2("ab!cde!12!45!1!", "ab"));
		
	}

}
