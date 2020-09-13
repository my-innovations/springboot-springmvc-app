package com.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class User implements Serializable{

	private static final long serialVersionUID = 1293337135503757716L;

	private Long id;
	
	//@NotEmpty
	@NotEmpty(message="{NotEmpty.user.name}") //OK
	//@Size(min=5,max=15,message="not meet required length")
	private String name;
	
	@NotEmpty
	//@NotEmpty(message="{NotEmpty.user.email}") //OK
	@Email
	private String email;
	
	@Positive
	private int age;
	
	private Date dob;
	
	public User(){}
	
	public User(@NotEmpty String name, @Positive int age, @NotEmpty @Email String email,Date dob) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.dob=dob;
	}
	
	public User(Long id, @NotEmpty String name, @Positive int age, @NotEmpty @Email String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}

}
