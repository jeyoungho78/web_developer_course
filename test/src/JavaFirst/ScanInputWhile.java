package JavaFirst;

import java.util.Scanner;

public class ScanInputWhile {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numInt;
		float numFloat, sum;
		String inString;
		
		System.out.print("이름을 입력하세요 : ");
		inString =scanner.next(); //대기하고 있다가 입력이 일어나면 읽음
		
		System.out.print("정수형과 실수형 숫자 2개를 입력하세요 : ");
		numInt = scanner.nextInt();
		numFloat = scanner.nextFloat();
		sum = numInt + numFloat;
		
		System.out.println("이름 : " + inString);
		System.out.println(numInt + " + " + numFloat + " = " + sum);
		
		
	}
	
}