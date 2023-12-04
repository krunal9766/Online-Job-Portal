package com.spring.job.service;

import java.util.List;

import com.spring.job.entity.Job;

public interface JobService {
		public Job addJobs(Job job);
		
		public List<Job> getAlljobs();
		
		public Job getJobById(int id);
		
		public void deleteJobById(int id);
		
		public List<Job> getJobByLocAndCat(String loc,String catgry);
		
		
		
		
		
}
