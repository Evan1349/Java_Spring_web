
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
import com.example.demo.Entity.User;



@RestController
@RequestMapping("/api/v1")
public class Usercontroller {

	@Autowired
	Userservice userService;
	
	@GetMapping("/users/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		return ResponseEntity.ok(userService.getUser(username));
	}
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	@DeleteMapping("/users/{usernameDelete}")
	public ResponseEntity<List<User>> deleteUser(@PathVariable("usernameDelete") String username){
		ResponseEntity.ok(userService.deleteUser(username));
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/users/{usernameSearch}")
	public ResponseEntity<List<User>> searchUser(@PathVariable("usernameSearch") String username){
		return ResponseEntity.ok(userService.searchUser(username));
	}
	
	
}
