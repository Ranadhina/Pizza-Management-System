package com.pizzamanagement.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzamanagement.user.entity.UserEntity;
import com.pizzamanagement.user.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserServiceImpl userServiceImpl;

	@PostMapping
	public UserEntity saveUser(@RequestBody UserEntity user) {
		return userServiceImpl.addUser(user);
	}

	@DeleteMapping("/{id}")
	public String removeUser(@PathVariable Integer id) {
		return userServiceImpl.deleteUser(id);
	}
	
	@GetMapping("/{id}")
	public UserEntity searchById(@PathVariable Integer id) {
		return userServiceImpl.findById(id);
	}
	
	@GetMapping
	public List<UserEntity> searchAll(){
		return userServiceImpl.findAll();
	}
    
	@PutMapping
	public UserEntity updateUser(@RequestBody UserEntity user) {
		return userServiceImpl.updateUser(user);
	}
}
