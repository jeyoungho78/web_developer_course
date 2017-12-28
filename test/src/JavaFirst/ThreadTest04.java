package JavaFirst;

public class ThreadTest04 {
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			Thread thread = new InnerThread("thread-" + i);
			
			if(i != 10 && i != 5) {
				thread.setPriority(Thread.MIN_PRIORITY); // 1
			} else if (i == 5) {
				thread.setPriority(Thread.NORM_PRIORITY); // 5
		    } else {
				thread.setPriority(Thread.MAX_PRIORITY);  // 10
			}
			
			thread.start();
		}
	}
}

class InnerThread extends Thread{
	
	public InnerThread(String threadName) {
		setName(threadName);
	}
	
	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			for (int i = 0; i < 30000000; i++) {
				Thread.sleep(1000);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println(getName() + "쓰레드 종료");
	}
}