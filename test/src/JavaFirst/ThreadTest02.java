package JavaFirst;

public class ThreadTest02 implements Runnable{

	String word;
	
	ThreadTest02(String word){
		this.word = word;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(i + "번째 : " + word);
		}
		
		System.out.println("쓰레드종료 : " + word);
		
	}

	public static void main(String[] args) {
		ThreadTest02 thread01 = new ThreadTest02("첫번째 쓰레드");
		ThreadTest02 thread02 = new ThreadTest02("두번째 쓰레드");
		
		// new Thread(thread01).start();
		// new Thread(thread02).start();
		
		Thread t1 = new Thread(thread01);
		Thread t2 = new Thread(thread02);
		
		System.out.println("t1 쓰레드이름 : " + t1.getName());
		System.out.println("t2 쓰레드이름 : " + t2.getName());
		
		t1.start();
		t2.start();
	}
	
}
