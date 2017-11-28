package exec.thread;


public class TutorialThread {
//	public static void main(String[] args) {
//		MultiThread mt1 = new MultiThread("Thread0");
//		MultiThread mt2 = new MultiThread("Thread1");
//		MultiThread mt3 = new MultiThread("Thread2");
//		
//		mt1.start();
//		mt2.start();
//		mt3.start();
//	}
/*	
	public static void main(String[] args) {
		MultiThread mt1 = new MultiThread("Thread0");
		MultiThread mt2 = new MultiThread("Thread1");
		MultiThread mt3 = new MultiThread("Thread2");
		
		Thread tr1 = new Thread(mt1);
		Thread tr2 = new Thread(mt2);
		Thread tr3 = new Thread(mt3);
		
		tr1.start();
		tr2.start();
		tr3.start();
	}*/
	
/*	public static void main(String[] args) {
		MultiThread mt1 = new MultiThread("Thread1");
		MultiThread mt2 = new MultiThread("Thread2");
		MultiThread mt3 = new MultiThread("Thread3");
		
		mt1.setPriority(Thread.MIN_PRIORITY);
		mt2.setPriority(Thread.NORM_PRIORITY);
		mt3.setPriority(Thread.MAX_PRIORITY);
		
		mt1.start();
		mt2.start();
		mt3.start();
	}*/
	
	public static void main(String[] args) {
		clsNumber number = new clsNumber();
		MultiThread mt1 = new MultiThread(number);
		MultiThread mt2 = new MultiThread(number);
		MultiThread mt3 = new MultiThread(number);
		
		mt1.start();
		mt2.start();
		mt3.start();
		
		try {
			mt1.join();
			mt2.join();
			mt3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(number.getNum());
	}
}
