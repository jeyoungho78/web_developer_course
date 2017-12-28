package JavaFirst;

//==========================
//������ A �� B �Լ��� �������� 
//A �� B �Լ��� ����ȭ : notify/wait�� ������ synchronized ����ȭ �ɼ��� �����  ����ȭ���� ���� ���յ��� �ʰ��ϰ� �������� ����ؾ� ��
//ex) ��������� ���ͳݹ�ũ     ����)�ӵ� ����
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

	public synchronized void methodA() {  //����ȭ �Լ� ����
	   System.out.println("method A �� ����Ǿ����ϴ�.");
	   notify(); //���� ������ �ٽ� ����
	   
	   try {
	      wait();
	   } catch (InterruptedException e) {
	      e.printStackTrace();
	   }
	}
	
	public synchronized void methodB() {
	   System.out.println("method B �� ����Ǿ����ϴ�.");
	   notify(); //���� ������ �ٽ� ����
	   
	   try {
	      wait();
	   } catch (InterruptedException e) {
	      e.printStackTrace();
	   }
	}

}//W.O