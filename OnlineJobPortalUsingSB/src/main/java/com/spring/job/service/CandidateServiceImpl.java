package com.spring.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.job.entity.Candidate;
import com.spring.job.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements  CandidateService{

	@Autowired 
	CandidateRepository candirepo;
	
	public Candidate addCandidate(Candidate candi) {
		Candidate candidate=candirepo.save(candi);
		return candidate;
	}
	
	public List<Candidate> getAllCandidates() {
		List<Candidate> candidates=candirepo.findAll();
		return candidates;
	}

	@Override
	public Candidate getCandidateById(int cid) {
		Candidate candidate=candirepo.findById(cid).get();
		return candidate;
	}
	
}
