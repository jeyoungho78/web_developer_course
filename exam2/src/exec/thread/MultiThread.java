package exec.thread;

/*public class MultiThread extends Thread{

	String name;
	
	public MultiThread(String name) {
		System.out.println(getName() + "스레드가 생성되었습니다.");
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println(getName() + "(" + name + ")");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}*/

/*public class MultiThread implements Runnable{

	String name;
	
	public MultiThread(String name) {
		System.out.println(name + "스레드가 생성되었습니다.");
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "(" + name + ")");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}*/

/*public class MultiThread extends Thread {
	String name;

	public MultiThread(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(name + "(우선 순위 : " + getPriority() + ")");
		}
	}

}// class*/

public class MultiThread extends Thread {
	clsNumber number;
	
	public MultiThread(clsNumber number) {
		this.number = number;
	}
	
	public void run() {
		for(int i = 0; i < 50000; i++) {
			number.addNum();
		}
	}
}
