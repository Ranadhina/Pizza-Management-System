package com.pizzamanagement.pizzaorder.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagement.pizzaorder.client.CartService;
import com.pizzamanagement.pizzaorder.entity.Cart;
import com.pizzamanagement.pizzaorder.entity.PizzaOrder;
import com.pizzamanagement.pizzaorder.repository.PizzaOrderRepository;
import com.pizzamanagement.pizzaorder.service.PizzaOrderService;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {

	@Autowired
	PizzaOrderRepository pizzaorderRepository;

	@Autowired
	CartService cartService;

	@Override
	public PizzaOrder addPizzaOrder(PizzaOrder pizzaorder) {
		Double price = 0.00;
		for(Integer a:pizzaorder.getCartId()) {
			Cart cart = cartService.searchByCartId(a);
			price = price + cart.getTotalPrice();
		}
		pizzaorder.setTotalCost(price);

		return pizzaorderRepository.save(pizzaorder);
	}

	@Override
	public String deletePizzaOrder(Integer pizzaorderId) {

		if (!pizzaorderRepository.findById(pizzaorderId).isEmpty())

		{
			pizzaorderRepository.deleteById(pizzaorderId);
			return "Order Cancelled Successfully";
		} else {
			return "Order Not Found";
		}
	}

	@Override
	public PizzaOrder findPizzaOrderById(Integer pizzaorderId) {
		
		PizzaOrder order=pizzaorderRepository.findById(pizzaorderId).get();
		if(order.getBookingOrderId()==null)
		{
			throw new IllegalArgumentException("Orders not found");
		}
		return order;

	}

	@Override
	public PizzaOrder updatePizzaOrder(PizzaOrder pizzaorder) {
		PizzaOrder updatePizzaOrder = pizzaorderRepository.findById(pizzaorder.getBookingOrderId()).get();
		if(updatePizzaOrder.getBookingOrderId()==null) {
			throw new IllegalArgumentException("Order Id not found");
		}
		else {
		List<Integer> upCartId = new ArrayList<>();
		Double price = 0.00;
		for(Integer a:pizzaorder.getCartId()) {
			Cart cart = cartService.searchByCartId(a);
			upCartId.add(a);
			price = price + cart.getTotalPrice();
		}
		pizzaorder.setTotalCost(price);
		updatePizzaOrder.setCartId(upCartId);
     	updatePizzaOrder.setDateTimeOfOrder(LocalDateTime.now());
		updatePizzaOrder.setPizzaStatus(pizzaorder.getPizzaStatus());
		updatePizzaOrder.setTotalCost(price);
		updatePizzaOrder.setUserId(pizzaorder.getUserId());
		return pizzaorderRepository.save(updatePizzaOrder);
		}
	}

	@Override
	public List<PizzaOrder> findAllPizzaOrder() {
		
		List<PizzaOrder> pizzaorders = pizzaorderRepository.findAll();
		if(pizzaorders.isEmpty())
		{
			throw new IllegalArgumentException("Orders not found");
		}
		return  pizzaorders;
	}

	@Override
	public List<PizzaOrder> findPizzaOrderByUserId(Integer id) {
		
		List<PizzaOrder> orders=pizzaorderRepository.findByUserId(id);
		if(orders.isEmpty())
		{
			throw new IllegalArgumentException("Orders not found");
		}
		return orders;
	}

}
