package JavaFirst;

/*
1)�ϳ��� ���� �ȿ��� public Ŭ������ �ϳ��� ����
2) public Ŭ������ �̸��� ������ �̸��� ������
3) main �޼ҵ带 ������ Ŭ�������� public Ŭ������ �� �� �ִ�. 
 */

class Man{
	int height;
	int age;
}//Man

public class FirstClass {	
	public static void main(String[] args) {
		
		Man man1;
		man1 = new Man();
		
		man1.height = 180;
		man1.age = 20;
		
		System.out.println(man1.height);
		System.out.println(man1.age);
		
	}//Main
}//FirstClass
