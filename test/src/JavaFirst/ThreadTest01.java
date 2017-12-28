package JavaFirst;

public class ThreadTest01 extends Thread {
	
	String word;
	
	ThreadTest01(String word){
		this.word = word;
	}
	
	@Override
	public void run() { // ������ ���� ����
		while(true) {
			System.out.println(word);
		}
		
	}
	
	public static void main(String[] args) {
		ThreadTest01 thread01 = new ThreadTest01("������ 1��");
		ThreadTest01 thread02 = new ThreadTest01("������ 2��");
		
		thread01.start();
		thread02.start();
	}

}
