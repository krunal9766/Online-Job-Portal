package com.spring.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.job.entity.Job;
import com.spring.job.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{
	@Autowired 
	JobRepository jobrepo;
	
	public Job addJobs(Job job) {
		Job jobb=jobrepo.save(job);
		return jobb;
	}

	public List<Job> getAlljobs() {
		List<Job> jobs=jobrepo.findAll();
		return jobs;
	}

	public Job getJobById(int id) {
		Job job=jobrepo.findById(id).get();
		return job;
	}
	
	public void deleteJobById(int id) {
		jobrepo.deleteById(id);
	}

	@Override
	public List<Job> getJobByLocAndCat(String loc, String catgry) {
		List<Job> jobs=jobrepo.findByLocationAndCategory(loc, catgry);
		return jobs;
	}

	
	
	 

}
