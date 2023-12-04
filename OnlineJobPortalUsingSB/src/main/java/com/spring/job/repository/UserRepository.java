package com.spring.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.job.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
		
}
