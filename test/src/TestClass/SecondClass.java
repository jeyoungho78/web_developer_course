package TestClass;

class Sample{

	int a;
	int b;
	int c;
	
}

public class SecondClass {
	
	public static void main(String[] args) {
		
		Sample s1 = new Sample();
	
		int sum = 0;
		double avg = 0.0;
		
		s1.a = 10;
		s1.b = 20;
		s1.c = 30;
		
		sum = s1.a + s1.b + s1.c;
		avg = (double)sum / 3.0;
		
		System.out.println("ЦђБе : " + avg);
		
	}
}
