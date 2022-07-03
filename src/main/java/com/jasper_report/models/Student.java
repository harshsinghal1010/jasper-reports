package com.jasper_report.models;

public class Student {

	private Long id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	public Student(Long id, String firstName, String lastName, String street, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
	}

	public Long getid() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getstreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", city=" + city + "]";
	}
}
