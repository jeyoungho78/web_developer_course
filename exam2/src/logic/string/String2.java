package logic.string;

public class String2 {
	
	String str;
	
	public String2(String str) {
		this.str = str;
	}
	
	public String subString(int beginIndex, int endIndex) {
		String result = "";
		
		for(int i = beginIndex; i < endIndex; i++) {
			result = result + String.valueOf(str.charAt(i));
		}
	
		return result;
	}//subString
	
	public String subString(String str, int beginIndex, int endIndex) {
		String result = "";
		
		for(int i = beginIndex; i < endIndex; i++) {
			result = result + String.valueOf(str.charAt(i));
		}
	
		return result;
	}//subString 
	
	public int countSearch(String str, char ch) {
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(ch == str.charAt(i)) {
				count = count + 1;
			}
		}
		
		return count;
	}// countSearch
	
	public int countSearch2(String str, String delimiter) {
		int count = 0;
		int fromIndex = -1;
		
		for(int i = 0; i < str.length(); i++) {
			fromIndex = str.indexOf(delimiter, fromIndex + 1);
			if(fromIndex >= 0 ) {
				count = count + 1;
			} else {
				break;
			}
		}
		
		return count;
	}//countSearch2
	
}
