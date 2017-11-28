package data.io;

import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class PersonalInfoData implements Serializable{
	private static final long serialVersionUID = -3468289106729523782L;
	String name;
	Date birthday;
	boolean gender;
	int age;
	int grade;
	
	public PersonalInfoData(String name, String birthday, boolean gender, int age, int grade){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthdayDate = sdf.parse(birthday);
			
			this.name = name;
			this.birthday = birthdayDate;
			this.gender = gender;
			this.age = age;
			this.grade = grade;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthdayDate = sdf.parse(birthday);
			
			this.birthday = birthdayDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}	
}
