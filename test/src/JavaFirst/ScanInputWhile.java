package JavaFirst;

import java.util.Scanner;

public class ScanInputWhile {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numInt;
		float numFloat, sum;
		String inString;
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		inString =scanner.next(); //����ϰ� �ִٰ� �Է��� �Ͼ�� ����
		
		System.out.print("�������� �Ǽ��� ���� 2���� �Է��ϼ��� : ");
		numInt = scanner.nextInt();
		numFloat = scanner.nextFloat();
		sum = numInt + numFloat;
		
		System.out.println("�̸� : " + inString);
		System.out.println(numInt + " + " + numFloat + " = " + sum);
		
		
	}
	
}