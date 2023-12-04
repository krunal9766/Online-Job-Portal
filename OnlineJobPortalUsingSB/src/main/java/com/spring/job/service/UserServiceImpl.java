package com.spring.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.job.entity.User;
import com.spring.job.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	UserRepository urepo;
	 
	public User addUser(User user) {
		User userr=urepo.save(user);
		return userr;
	}

}
