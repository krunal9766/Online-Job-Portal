package com.spring.job.service;

import java.util.List;

import com.spring.job.entity.Candidate;

public interface CandidateService {
	public Candidate addCandidate(Candidate candi);
	  
	public List<Candidate> getAllCandidates();
	
	public Candidate getCandidateById(int cid);
	
	
}
