package JavaFirst;

public class ContinueExample {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i <= 10; i++) {
			if(i % 2 != 0) {
				continue;
			}
			sum += i;
		}
		System.out.println("1~10������ ¦���� �� = " + sum);
		
		sum = 0;
		int loop = 0;
		while(loop < 10) {
			loop++;
			if(loop%2 == 0) {
				continue;
			}
			sum += loop;
		}
		System.out.println("1~10������ Ȧ���� �� = " + sum);
	}
}
