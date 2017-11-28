package JavaFirst;

public class LabelExample {
	public static void main(String[] args) {
		int[] numbers = new int[] {100, 18, 21, 30};
		
		OUTER:
		for(int i = 0; i < numbers.length; i++) {
			if(i % 2 == 0) {
				System.out.println("È¦¼ö: " + i + ", contine, OUTER label ÀÌµ¿");
				continue OUTER;
			}
			
			INNER:
				for(int j = 0; j < numbers.length; j++) {
					System.out.println("Â¦¼ö: " + j + ", contine, OUTER label Á¾·á");
					break INNER;
				}
				
		}
	}
}
