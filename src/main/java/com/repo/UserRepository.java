package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	    // JpaRepository already gives you methods like:
	    // save(), findById(), findAll(), deleteById(), etc.

	    // You can also add custom methods:
	    User findByUname(String uname);
	}



