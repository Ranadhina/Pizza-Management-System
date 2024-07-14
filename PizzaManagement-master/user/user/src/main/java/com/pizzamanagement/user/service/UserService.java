package com.pizzamanagement.user.service;

import java.util.List;

import com.pizzamanagement.user.entity.UserEntity;

public interface UserService {

	public UserEntity addUser(UserEntity user);

	public String deleteUser(Integer id);

	public UserEntity updateUser(UserEntity user);

	public UserEntity findById(Integer id);
	
	public List<UserEntity> findAll();

}
