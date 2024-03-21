package com.example.demo.Userservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

import jakarta.annotation.PostConstruct;

@Service
public class Userservice {
	
	private List<User> users = new ArrayList<>();
	
	// Constructor
	@PostConstruct
	public void init() {
		this.users.add(User.builder().username("Evan").password("abc123").email("abc@gmail.com").age(35).build()
				);
		this.users.add(User.builder().username("Franni").password("Geburtstag0920").email("Franni@gmail.com").age(35).build()
				);
		this.users.add(User.builder().username("Ryland").password("cool").email("ry@gmail.com").age(30).build()
				);
	}
	
	// getAllUser
	public List<User> getAllUser() {
		return this.users;
	};
	
	// getUser method:stream().filter().collect()
	public User getUser(String username) {
		List <User> result = users	.stream()
									.filter(user -> user.getUsername().equals(username))
									.collect(Collectors.toList());
		return result.get(0) ;
	}
	
	// addUser
	public List<User> addUser(User user) {
		this.users.add(user);
		return users;
	}
	
	// deleteUser
	public List<User> deleteUser(String username) {
		List<User> result= users.stream()
								.filter(users -> !users.getUsername().equals(username))
								.collect(Collectors.toList());
		return result;
	}
}
