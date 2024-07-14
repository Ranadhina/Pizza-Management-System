package com.pizzamanagement.pizzaorder.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	private Integer cartId;
	private Integer pizzaId;
	private List<Integer> toppingsId = new ArrayList<>();
	private Integer userId;
	private Integer quantity;
	private Double totalPrice;

}
