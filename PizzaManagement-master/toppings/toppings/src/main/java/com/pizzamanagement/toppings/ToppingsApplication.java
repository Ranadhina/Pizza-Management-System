package com.pizzamanagement.toppings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ToppingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToppingsApplication.class, args);
	}

}
