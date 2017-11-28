package data.generic;

/*public class Person <T, S> {
	
	public T info;
	public S id;
	
	public Person () {
	}
	
	public Person (T info, S id) {
		this.info = info;
		this.id = id;
	}

	public <U> void printInfo(U info) {
		System.out.println(info);
	}
}
*/

public class Person<T extends Info> {
	
	public T info;
	
	public Person (T info) {
		this.info = info;
	}
}
