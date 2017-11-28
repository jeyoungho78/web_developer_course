package JavaFirst;

/*
1)하나의 파일 안에서 public 클래스는 하나만 존재
2) public 클래스의 이름은 파일의 이름과 동일해
3) main 메소드를 포함한 클래스만이 public 클래스가 될 수 있다. 
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
