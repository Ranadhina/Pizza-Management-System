package com.pizzamanagement.cart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagement.cart.client.PizzaService;
import com.pizzamanagement.cart.client.ToppingsService;
import com.pizzamanagement.cart.client.UserService;
import com.pizzamanagement.cart.entity.Cart;
import com.pizzamanagement.cart.entity.Pizza;
import com.pizzamanagement.cart.entity.Toppings;
import com.pizzamanagement.cart.entity.UserEntity;
import com.pizzamanagement.cart.repository.CartRepository;
import com.pizzamanagement.cart.service.CartService;

import jakarta.ws.rs.NotFoundException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private UserService customerService;

	@Autowired
	private ToppingsService toppingsService;

	@Autowired
	public CartRepository cartRepository;

	@Override
	public Cart addCartItem(Cart cart) throws NotFoundException {
		UserEntity user = customerService.getUserById(cart.getUserId());
		Pizza pizza = pizzaService.getPizzaById(cart.getPizzaId());
		Cart resCart = new Cart();
		Double price = 0.00;

		try {
			if (user.getUserId() != null && pizza.getPizzaId() != null) {

				price = pizza.getPizzaCost();
				for (Integer id : cart.getToppingsId()) {
					Toppings toppings = toppingsService.getToppingsById(id);
					price = price + toppings.getPrice();
				}
				cart.setTotalPrice(cart.getQuantity() * price);
				resCart = cartRepository.save(cart);
			}
		} catch (NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		}

		return resCart;
	}

	@Override
	public String deleteCartItem(Integer cartId) {

		if (!cartRepository.findById(cartId).isEmpty()) {
			cartRepository.deleteById(cartId);
			return "Item Deleted Successfully";
		} else {
			return "No Item Found";
		}
	}

	@Override
	public Cart findCartItemById(Integer cartId) {
		return cartRepository.findById(cartId).get();
	}

	@Override
	public Cart updateCartItem(Cart cart) {

		if (cart.getCartId() == null || !cartRepository.existsById(cart.getCartId())) {
			throw new IllegalArgumentException("Cart not found");
		}
		UserEntity user = customerService.getUserById(cart.getUserId());
		Pizza pizza = pizzaService.getPizzaById(cart.getPizzaId());
		Double price = 0.00;

	
			if (user.getUserId() != null && pizza.getPizzaId() != null) {

				price = pizza.getPizzaCost();
				for (Integer id : cart.getToppingsId()) {
					Toppings toppings = toppingsService.getToppingsById(id);
					price = price + toppings.getPrice();
				}
			}
			

		Cart upCart = cartRepository.findById(cart.getCartId()).get();
		upCart.setPizzaId(cart.getPizzaId());
		upCart.setQuantity(cart.getQuantity());
		upCart.setToppingsId(cart.getToppingsId());
		upCart.setTotalPrice(cart.getQuantity() * price);
		upCart.setUserId(cart.getUserId());
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> findAllCartItems() {
		return cartRepository.findAll();
	}

	@Override
	public List<Cart> findCartByUserId(Integer id) {
		return cartRepository.findByUserId(id);
	}

}
