package com.pizzamanagement.pizzaorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.pizzamanagement.pizzaorder.client"})
public class PizzaorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaorderApplication.class, args);
	}

}
