package data.io;

public class HousePeopleData {

	String name;
	int age;
	boolean houseHolder;

	public HousePeopleData() {

	}

	public HousePeopleData(String name, int age, boolean houseHolder) {
		this.name = name;
		this.age = age;
		this.houseHolder = houseHolder;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHouseholder() {
		return houseHolder;
	}

	public void setHouseholder(boolean houseHolder) {
		this.houseHolder = houseHolder;
	}

}
