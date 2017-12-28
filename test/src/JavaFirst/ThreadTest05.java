package JavaFirst;

//==========================
//쓰레드 A 와 B 함수를 교차실행 
//A 와 B 함수의 동기화 : notify/wait을 쓰려면 synchronized 동기화 옵션을 사용해  동기화시켜 값을 병합되지 않게하고 유지시켜 사용해야 함
//ex) 은행입출금 인터넷뱅크     단점)속도 느림
//==========================

public class ThreadTest05 {

	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
	
		Thread threadA = new ThreadA(workObject);
		Thread threadB = new ThreadB(workObject);
	
		threadA.start();
		threadB.start();
	}
}//05

class ThreadA extends Thread{

	WorkObject workObject;
	
	public ThreadA(WorkObject workObject) {
	   this.workObject = workObject;
	}
	
	@Override
	public void run() {
	   for(int i = 0; i<10; i++) {
	      workObject.methodA();
	   }
	}
}//A==============================================

class ThreadB extends Thread{
	WorkObject workObject;
	
	public ThreadB(WorkObject workObject) {
	   this.workObject = workObject;
	}
	
	@Override
	public void run() {
	   for(int i = 0; i<10; i++) {
	      workObject.methodB();
	   }
	}
}//B==============================================




class WorkObject{

	public synchronized void methodA() {  //동기화 함수 실행
	   System.out.println("method A 가 실행되었습니다.");
	   notify(); //죽은 쓰레드 다시 실행
	   
	   try {
	      wait();
	   } catch (InterruptedException e) {
	      e.printStackTrace();
	   }
	}
	
	public synchronized void methodB() {
	   System.out.println("method B 가 실행되었습니다.");
	   notify(); //죽은 쓰레드 다시 실행
	   
	   try {
	      wait();
	   } catch (InterruptedException e) {
	      e.printStackTrace();
	   }
	}

}//W.O