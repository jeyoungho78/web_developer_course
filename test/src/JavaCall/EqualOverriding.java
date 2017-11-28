package JavaCall;

public class EqualOverriding {
	int a;
	String str;
	
	public EqualOverriding() {
		
	}
	
	public EqualOverriding(String str) {
		this.str = str;
	}
	
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	/*public boolean equals(Object obj) {
		if(this.a == ((EqualOverriding)obj).a) {
			return true;
		} else  {
			return false;
		}
	}*/
	
	public boolean equals(Object obj) {
		if(this.str == ((EqualOverriding)obj).str) {
			return true;
		} else  {
			return false;
		}
	}
}
