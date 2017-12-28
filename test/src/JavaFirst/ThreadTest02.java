package JavaFirst;

public class ThreadTest02 implements Runnable{

	String word;
	
	ThreadTest02(String word){
		this.word = word;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(i + "��° : " + word);
		}
		
		System.out.println("���������� : " + word);
		
	}

	public static void main(String[] args) {
		ThreadTest02 thread01 = new ThreadTest02("ù��° ������");
		ThreadTest02 thread02 = new ThreadTest02("�ι�° ������");
		
		// new Thread(thread01).start();
		// new Thread(thread02).start();
		
		Thread t1 = new Thread(thread01);
		Thread t2 = new Thread(thread02);
		
		System.out.println("t1 �������̸� : " + t1.getName());
		System.out.println("t2 �������̸� : " + t2.getName());
		
		t1.start();
		t2.start();
	}
	
}
