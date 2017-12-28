package com.example.spring.entity;

public class Member {
	String id;
	String name;
	String email;
	String gender;
	String[] hobby;
	String selAnimal;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSelAnimal() {
		return selAnimal;
	}
	public void setSelAnimal(String selAnimal) {
		this.selAnimal = selAnimal;
	}
	
}
