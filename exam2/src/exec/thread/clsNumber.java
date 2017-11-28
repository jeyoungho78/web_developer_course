package exec.thread;

public class clsNumber {
	int num = 0;

	public void addNum() {
		synchronized (this) {
			num++;
		}
	}

	public int getNum() {
		return num;
	}
}
