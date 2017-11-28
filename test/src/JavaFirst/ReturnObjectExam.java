package JavaFirst;

public class ReturnObjectExam {
	
	String key;
	
	int a, b;
	
	ReturnObjectExam(String key){
		this.key = key;
	}
	
	ReturnObjectExam(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	ReturnObjectExam getObject() {
		return this;
	}
	
	ReturnObjectExam twice() {
		return new ReturnObjectExam(2 * a, 2 * b);
	}
	
}
