package com.spring.job.entity;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;

@Component
@Entity
public class Candidate {
	@Id
	@GeneratedValue(generator="candt_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="candt_gen",sequenceName="candt_seq",initialValue=1,allocationSize=1)
	private int candid;
	private String fname;
	private String lname;
	private String email;
	private String city;
	private String pnumber;
	private String qualification;
	@Lob
	private byte[] resume;
	public Candidate(int candid, String fname, String lname, String email, String city, String pnumber,
			String qualification, byte[] resume) {
		super();
		this.candid = candid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.city = city;
		this.pnumber = pnumber;
		this.qualification = qualification;
		this.resume = resume;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCandid() {
		return candid;
	}
	public void setCandid(int candid) {
		this.candid = candid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "Candidate [candid=" + candid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", city="
				+ city + ", pnumber=" + pnumber + ", qualification=" + qualification + ", resume="
				+ Arrays.toString(resume) + "]";
	}
	
	
	
	
}
