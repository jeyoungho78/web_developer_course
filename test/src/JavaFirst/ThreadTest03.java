package JavaFirst;

public class ThreadTest03 {
	
	public static void main(String[] args) throws Exception {
		RunnerableThread rThread = new RunnerableThread();
		Thread t = new Thread(rThread);
		t.start();
		t.join();
		System.out.println("sum°ª : " + rThread.getSum());
	}
	
}

class RunnerableThread implements Runnable{
	
	int sum = 0;
	
	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			sum = sum + i;
		}
	}
	
	
	
}
