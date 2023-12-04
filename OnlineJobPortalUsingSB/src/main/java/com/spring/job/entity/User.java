package com.spring.job.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Component
@Entity  
public class User {
	@Id
	@GeneratedValue(generator="user_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="user_gen",sequenceName="user_seq",initialValue=50,allocationSize=1)
	private int userid;
	private String name;
	private String qualification;
	private String email;
	private String password;
	
	public User(String name, String qualification, String email, String password) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.email = email;
		this.password = password;
	}
	
	public User() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", qualification=" + qualification + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	

}
