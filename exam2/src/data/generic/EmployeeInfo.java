package data.generic;

public class EmployeeInfo implements Info{

	public int rank;
	
	public EmployeeInfo(int rank) {
		this.rank = rank;
	}
	
	public int getLevel() {
		return this.rank;
	}
	
}
