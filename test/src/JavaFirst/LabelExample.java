package JavaFirst;

public class LabelExample {
	public static void main(String[] args) {
		int[] numbers = new int[] {100, 18, 21, 30};
		
		OUTER:
		for(int i = 0; i < numbers.length; i++) {
			if(i % 2 == 0) {
				System.out.println("Ȧ��: " + i + ", contine, OUTER label �̵�");
				continue OUTER;
			}
			
			INNER:
				for(int j = 0; j < numbers.length; j++) {
					System.out.println("¦��: " + j + ", contine, OUTER label ����");
					break INNER;
				}
				
		}
	}
}
