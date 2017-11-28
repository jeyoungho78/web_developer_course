package exec;

import logic.Gugudan2;

public class GugudanExec2 {
	
	public static void main(String[] args) {
		
		Gugudan2 gu = new Gugudan2();
		gu.setA(2);
		gu.setB(3);
		
		//gu.multi(gu.getA());
		gu.multi(gu.getA(), gu.getB());
		
	}
	
}
