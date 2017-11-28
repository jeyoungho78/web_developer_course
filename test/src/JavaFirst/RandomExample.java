package JavaFirst;

import java.util.Random;

public class RandomExample {
	
public static void main(String[] args){
        
        // Random() 객체 생성
        Random generator = new Random();        
        
        int num1;
        float num2;
        
        // int 값의 범위에서 정수 랜덤값을 추출한다.
        // (-2,147,483,648 ~2,147,483,647)
        num1= generator.nextInt();         
        System.out.println("A random integer: "+num1);  
        
        // 0~9 사이의 정수 랜덤값을 추출한다.
        num1= generator.nextInt(10);            
        System.out.println("Form 0 to 9: " + num1);
        
        // 1~10 사이의 정수랜덤값을 추출한다.
        num1= generator.nextInt(10) + 1;        
        System.out.println("Form 1 to 10 : " + num1);
        
        // 20~34 사이의 정수 랜덤값을 추출한다.
        num1= generator.nextInt(15) + 20;      
        System.out.println("Form 20 to 34: " + num1);
        
        // -10 ~ 9 사이의 정수 랜덤값을 추출한다.
        num1= generator.nextInt(20) - 10;      
        System.out.println("Form -10 to 9: " + num1);
        
        // 0.0(포함) ~ 1.0(포함안함) 사이의 난수를 추출한다.
        num2= generator.nextFloat();            
        System.out.println("A random float(between 0-1): " + num2);
        
        // 0.0 ~ 5.9999999 사이의 난수를 추출한다.
        // int로 형 변환(0~5) 후 1을 더한다.
        // 1~6 사이의 난수를 출력한다.
        num2 = generator.nextFloat()*6; 
        num1 = (int)num2 + 1;         
        System.out.println("From 1 to 6: " + num1);  
             
    }
}
