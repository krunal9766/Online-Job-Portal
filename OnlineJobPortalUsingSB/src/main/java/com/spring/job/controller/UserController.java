package com.spring.job.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.job.entity.Candidate;
import com.spring.job.entity.Job;
import com.spring.job.entity.User;
import com.spring.job.service.CandidateServiceImpl;
import com.spring.job.service.JobServiceImpl;
import com.spring.job.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userserviceimpl;
	
	@Autowired
	JobServiceImpl jobserviceimpl;
	
	@Autowired
	CandidateServiceImpl candserviceimpl;
	
	@Autowired
	User user;
	
	@Autowired
	Job job;
	
	@Autowired
	Candidate candi;
	
	@GetMapping("/user")                      		                // jobHome.html
	public String admin(Model model) {
		List<Job> jobs=jobserviceimpl.getAlljobs();
		model.addAttribute("jobs", jobs);
		for(Job job:jobs) {
			System.out.println(job);
		}
		return "alljobsforuser";
	}
	
	@GetMapping("/user/userHomeViewMore/{jid}")     		        // userHomeViewMore
	public String userViewMore(@PathVariable("jid") int jid,Model model) {
		Job job=jobserviceimpl.getJobById(jid);
		model.addAttribute("job", job);
		return "userviewmore";
	}
	
	@GetMapping("/user/applyFromHome")        						// 
	public String applyFromHome() {               
		return "apply";
	}
	
	@GetMapping("/user/userHomeViewMore/applyFromViewMore")        		// 
	public String applyFromViewMore() {               
		return "apply";
	}
	
	@GetMapping("/user/filterLocCat") 
	public String LocAndCatJob(@RequestParam("location") String location,@RequestParam("category") String category,Model model) {
		List<Job> jobsByLocAndCat=jobserviceimpl.getJobByLocAndCat(location, category);
		model.addAttribute("jobs", jobsByLocAndCat );
		return "locandcatjob";
	}
	
	@GetMapping("/user/filterLocCat/applyFromFilter")
	public String applyFromFilter() {
		return "apply";
	}
	
	@PostMapping("/apply")
	public String uploadStudent(@RequestParam("fname") String fname1, @RequestParam("lname") String lname1,
			@RequestParam("email") String email1, @RequestParam("city") String city1,
			@RequestParam("pnumber") String pnumber1, @RequestParam("qualification") String qualification1,
			@RequestParam("resume") MultipartFile resume1) throws IOException {
		candi.setFname(fname1);
		candi.setLname(lname1);
		candi.setEmail(email1);
		candi.setCity(city1);
		candi.setPnumber(pnumber1);
		candi.setQualification(qualification1);
		candi.setResume(resume1.getBytes());
		
		candserviceimpl.addCandidate(candi);
		
		return "apply";
	}
	
	
	@GetMapping("/download/{cid}")
    public ResponseEntity<byte[]> downloadResume(@PathVariable("cid") int id) {
    	Candidate candidate=candserviceimpl.getCandidateById(id);
            return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=resume.pdf")
                .body(candidate.getResume());
    }
	
}



//th:href="@{/jobHome/user/userHomeViewMore/{jid}(jid=${job.jobid})}"
