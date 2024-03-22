package com.example.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class User {
	private String username;
	private String password;
	private String email;
	private int age;
}