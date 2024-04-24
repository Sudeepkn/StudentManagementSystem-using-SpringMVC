package com.techpalle.model;

public class Student {
    private int Id;
    private String name;
    private String email;
    private String password;
    private long mobile;
    
	public Student() {
		super();
	}
	
	public Student(String name, String email, String password, long mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public Student(int id, String name, String email, String password, long mobile) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
    
}
