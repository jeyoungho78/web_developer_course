package JavaFirst;

public class PrivateClass {

	private int num;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	private void callPrivate() {
		System.out.println("Call Private Function");
	}
	
	public void call() {
		System.out.println("Call Public Function");
	}
	
}
