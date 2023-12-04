package com.spring.job.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Component
@Entity
public class Job {
	@Id
	@GeneratedValue(generator="job_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="job_gen",sequenceName="job_seq",initialValue=100,allocationSize=1)
	private int jobid;
	private String title;
	private String location;
	private String category;
	private String status;
	private String description;
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Job(int jobid,String title, String location, String category, String status, String description) {
		super();
		this.jobid=jobid;
		this.title = title;
		this.location = location;
		this.category = category;
		this.status = status;
		this.description = description;
	}

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Job [title=" + title + ", location=" + location + ", category=" + category + ", status=" + status
				+ ", description=" + description + "]";
	}
	
}
