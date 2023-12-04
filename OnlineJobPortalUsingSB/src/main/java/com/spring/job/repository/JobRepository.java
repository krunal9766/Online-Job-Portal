package com.spring.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.job.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer>{
		
	List<Job> findByLocationAndCategory(String location, String category);

}
