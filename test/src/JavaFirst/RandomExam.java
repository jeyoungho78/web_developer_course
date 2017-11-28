package JavaFirst;

import java.util.Random;

public class RandomExam {

	public static void main(String[] args) {
		
		Random generator = new Random();
		
		int num1;
		float num2;
		
		num1 = generator.nextInt();
		System.out.println(num1);
		
		num1 = generator.nextInt(10);
		System.out.println(num1);
		
		num1 = generator.nextInt(10) + 1;
		System.out.println(num1);
		
		num1 = generator.nextInt(15) + 20;
		System.out.println(num1);
		
		num1 = generator.nextInt(20) - 10;
		System.out.println(num1);
		
		num2 = generator.nextFloat();
		System.out.println(num2);
		
		num2 = generator.nextFloat()*6;
		System.out.println(num2);
		

	}
	
}
