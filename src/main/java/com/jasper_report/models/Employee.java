package com.jasper_report.models;

public class Employee {
	private Long id;
	private String name;
	private String address;
	private String mobile;
	public Employee(Long id, String name, String address, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
}
