package com.spring.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.model.User;

@RestController
public class UserController {
	
	@GetMapping("/user")
	public User getUser(@RequestParam(value="firstName", defaultValue="Tushar") String firstName) {
		
		User user = new User();
		user.setFirstName(firstName);
		
		return user;	
	}
	
	@PostMapping("/user")
	public User getUser(@RequestBody User user) {
		System.out.println("First Name: " + user.getFirstName());
		return user;	
	}
}
