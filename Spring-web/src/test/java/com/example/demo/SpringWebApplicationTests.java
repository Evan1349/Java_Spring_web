package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Userservice.Userservice;
import com.example.demo.entity.User;

@SpringBootTest
class SpringWebApplicationTests {

	@Autowired
	Userservice userService;
	
	// allUser
	@Test
	void contextLoads1() {
		List<User> users =userService.getAllUser();
		System.out.println(users);
		System.out.println(users.size());
		
	}
	
	// search
	@Test
	void contextLoads2() {
		User users = userService.getUser("Evan");
		System.out.println(users);
	}
	
	// add
	@Test
	void contextLoads3() {
		User user = User.builder()
						.username("Kevin")
						.password("123")
						.email("abcdefg@gmail.com")
						.age(20)
						.build();
		
		userService.addUser(user);
		
		System.out.println(userService.getAllUser());
		System.out.println(userService.getAllUser().size());
	}
	
	// delete
	@Test
	void contextLoads4() {
		List<User> users = userService.deleteUser("Evan");
		System.out.println(users);
		System.out.println(users.size());
	}
}