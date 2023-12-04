 package com.spring.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.job.entity.Candidate;
import com.spring.job.entity.Job;
import com.spring.job.entity.User;
import com.spring.job.service.CandidateServiceImpl;
import com.spring.job.service.JobServiceImpl;
import com.spring.job.service.UserServiceImpl;

	// localhost:8080/jobHome

@Controller
public class AdminController {
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
	
	
	@GetMapping("/jobHome")
	public String home() {
		return "home";
	}
	
	@GetMapping("/jobHome/signup")
	public String signup(Model model) { // user object willbe created and will be used in signup page while adding users
		userserviceimpl.addUser(user);
		model.addAttribute("user", user);
		return "signup";
	}
	
	@PostMapping("/adduser")
	public String adduser(@ModelAttribute("user") User user,Model model) {
		System.out.println(user);
		User userr=userserviceimpl.addUser(user);
		model.addAttribute("user", userr);
		model.addAttribute("msg", "Successfully signed up!!!!");
		return "signup";
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		return "admin"; 
	}
	
	@GetMapping("/admin/addJob")                                  // admin.html 
	public String addJob(Model model) {
		model.addAttribute("job", job);
		return "addjob";
	}
	
	@PostMapping("/addjob")                                              // form url
	public String addjob(@ModelAttribute Job job,Model model) {
		System.out.println(job);
		Job jobb=jobserviceimpl.addJobs(job);
		model.addAttribute("job", jobb);
		model.addAttribute("msg", "Successfully added a job!!!!");
		return "addjob";
	}
	
	@GetMapping("/admin/viewJob")                                // admin.html
	public String viewJob(Model model) {
		List<Job> jobs=jobserviceimpl.getAlljobs();
		model.addAttribute("jobs", jobs);
		return "viewjob";
	}
	
	@GetMapping("/admin/viewJob/getToUpdateJob/{jid}")                // viewjob.html
	public String getJobToUpdateJob(@PathVariable("jid") int id, Model model) {
		Job job=jobserviceimpl.getJobById(id);
		model.addAttribute("job", job);
		return "updatejob";
	}
	
	@GetMapping("/admin/viewJob/getToUpdateJob/update")                // viewjob.html
	public String updateJob(@ModelAttribute Job job) {
		jobserviceimpl.addJobs(job);
		return "redirect:/jobHome/admin/viewJob";
	}
	
	@GetMapping("/admin/viewJob/deleteJob/{jid}")              	 // viewjob.html
	public String deleteJob(@PathVariable("jid") int jobid) {
		jobserviceimpl.deleteJobById(jobid);
		return "redirect:/jobHome/admin/viewJob";
	}
	
	@GetMapping("/admin/viewCandidates")                         //admin.html
	public String viewCandidates(Model model) {
		List<Candidate> candidates=candserviceimpl.getAllCandidates();
		model.addAttribute("candidates", candidates);
		return "candidates";
	}

}
