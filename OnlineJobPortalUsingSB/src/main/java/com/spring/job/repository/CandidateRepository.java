package com.spring.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.job.entity.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer>{

}
