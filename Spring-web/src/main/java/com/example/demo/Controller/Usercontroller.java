
package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.Userservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.Entity.User;



@RestController
@RequestMapping("/api/v1")
@Tag(name = "User Controller", description = "API related to User")
public class Usercontroller {

	@Autowired
	Userservice userService;
	
	// get a user
	@Operation( summary= "To get a user's detail", description= "Enter the full name to get user's information")
	@GetMapping("/users/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		User user = userService.getUser(username);
		if (user==null) 
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}
	
	// all users
	@Operation( summary= "To get all users", description= "Getting all users detail!")
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	// add 
	@Operation( summary= "Create a user", description= "")
	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	// delete
	@Operation( summary= "Delete a user", description= "")
	@DeleteMapping("/users/{usernameDelete}")
	public ResponseEntity<List<User>> deleteUser(@PathVariable("usernameDelete") String username){
		ResponseEntity.ok(userService.deleteUser(username));
		return ResponseEntity.noContent().build();
	}
	
<<<<<<< HEAD
	// search
	@Operation( summary= "Search a user", description= "Using a letter to search user's detail ")
	@GetMapping("/users/{usernameSearch}/search")
=======
	@GetMapping("/users/{usernameSearch}/Search")
>>>>>>> 5a3dd1e7982e7d05f97d97d847805497f2c21a33
	public ResponseEntity<List<User>> searchUser(@PathVariable("usernameSearch") String username){
		List<User> user= userService.searchUser(username);
		if (user==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}
}
