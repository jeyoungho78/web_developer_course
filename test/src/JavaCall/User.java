package JavaCall;

import java.io.*;

public class User implements Serializable{
	private static final long serialVersionUID = 132132503809814679L;
	private String firstName;
	private String lastName;
	private String email;
	
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.firstName.equals(((User)obj).firstName)
				&& this.lastName.equals(((User)obj).lastName)
				&& this.email.equals(((User)obj).email));
	}
	
	@Override
	public String toString() {
		return getFirstName() + " "
			+ getLastName() + " " + getEmail();
	}
	
}
