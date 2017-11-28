package JavaFirst;

import java.util.Random;

public class RandomExample {
	
public static void main(String[] args){
        
        // Random() ��ü ����
        Random generator = new Random();        
        
        int num1;
        float num2;
        
        // int ���� �������� ���� �������� �����Ѵ�.
        // (-2,147,483,648 ~2,147,483,647)
        num1= generator.nextInt();         
        System.out.println("A random integer: "+num1);  
        
        // 0~9 ������ ���� �������� �����Ѵ�.
        num1= generator.nextInt(10);            
        System.out.println("Form 0 to 9: " + num1);
        
        // 1~10 ������ ������������ �����Ѵ�.
        num1= generator.nextInt(10) + 1;        
        System.out.println("Form 1 to 10 : " + num1);
        
        // 20~34 ������ ���� �������� �����Ѵ�.
        num1= generator.nextInt(15) + 20;      
        System.out.println("Form 20 to 34: " + num1);
        
        // -10 ~ 9 ������ ���� �������� �����Ѵ�.
        num1= generator.nextInt(20) - 10;      
        System.out.println("Form -10 to 9: " + num1);
        
        // 0.0(����) ~ 1.0(���Ծ���) ������ ������ �����Ѵ�.
        num2= generator.nextFloat();            
        System.out.println("A random float(between 0-1): " + num2);
        
        // 0.0 ~ 5.9999999 ������ ������ �����Ѵ�.
        // int�� �� ��ȯ(0~5) �� 1�� ���Ѵ�.
        // 1~6 ������ ������ ����Ѵ�.
        num2 = generator.nextFloat()*6; 
        num1 = (int)num2 + 1;         
        System.out.println("From 1 to 6: " + num1);  
             
    }
}
