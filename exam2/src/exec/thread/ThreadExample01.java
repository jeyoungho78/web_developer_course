package exec.thread;

class ThreadA extends Thread {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 1000; i++) {
				//Thread.sleep(300);
				System.out.println("채팅 대화");
			}
			super.run();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class ThreadB extends Thread {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 1000; i++) {
				//Thread.sleep(300);
				System.out.println("파일 전송");
			}
			super.run();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

public class ThreadExample01 {

	public static void main(String[] args) {
		try {
			ThreadA a = new ThreadA();
			ThreadB b = new ThreadB();

			a.start();
			b.start();
			
			a.join();
			b.join();
			
			System.out.println("프로그램 종료!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
