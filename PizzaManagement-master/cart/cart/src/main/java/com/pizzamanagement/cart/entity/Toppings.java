package com.pizzamanagement.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Toppings {

	private Integer toppingsId;
	private String toppingName;
	private Double price;

}
