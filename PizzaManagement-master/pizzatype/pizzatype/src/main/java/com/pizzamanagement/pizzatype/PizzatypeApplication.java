package com.pizzamanagement.pizzatype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PizzatypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzatypeApplication.class, args);
	}

}
