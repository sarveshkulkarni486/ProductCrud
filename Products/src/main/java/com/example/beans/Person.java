package com.example.beans;

public class Person {
	private String firstname;
	private String lastname;
	private String gender;
	private String city;
	public Person() {
		super();
	}
	public Person(String firstname, String lastname, String gender, String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.city = city;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lname) {
		this.lastname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", city=" + city
				+ "]";
	}
	
	

}
