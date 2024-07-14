package com.pizzamanagement.user.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagement.user.entity.UserEntity;
import com.pizzamanagement.user.repository.UserRepository;
import com.pizzamanagement.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository userRepository;

	@Override
	public UserEntity addUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(Integer id) {

		if (!userRepository.findById(id).isEmpty()) {
			userRepository.deleteById(id);
			return "User Deleted Successfully";
		} else {
			return "No user found";
		}
	}

	public UserEntity updateUser(UserEntity user) {
	    if (user.getUserId() == null || !userRepository.existsById(user.getUserId())) {
	        throw new IllegalArgumentException("User not found");
	    }
	    
	    UserEntity existingUser = userRepository.findById(user.getUserId()).get();
	    existingUser.setUserName(user.getUserName());
	    existingUser.setEmail(user.getEmail());
	    existingUser.setPassword(user.getPassword());
	    existingUser.setUserRole(user.getUserRole());
	    
	    return userRepository.save(existingUser);
	}
	@Override
	public UserEntity findById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
		
	}

}
