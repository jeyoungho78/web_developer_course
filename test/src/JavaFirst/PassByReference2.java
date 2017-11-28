package JavaFirst;

public class PassByReference2 {
	
	private int a;
	
	public PassByReference2(int a) {
		this.a = a;
	}
	
	public void twice(PassByReference2 o) {
		o.a *= 2;
	}
	
	public int getA() {
		return a;
	}
	
	void play(String name) {
		String a = name + "¾ß ³îÀÚ.";
		System.out.println(a);
	}
}
