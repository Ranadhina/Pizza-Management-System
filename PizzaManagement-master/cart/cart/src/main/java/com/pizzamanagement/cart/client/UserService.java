package com.pizzamanagement.cart.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pizzamanagement.cart.entity.UserEntity;

@FeignClient(name="user", url="http://localhost:8095")
public interface UserService {
	
	@GetMapping("user/{id}")
	public UserEntity getUserById(@PathVariable(value = "id") int id);

}
