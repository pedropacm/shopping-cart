package com.facilit.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facilit.shoppingcart.model.Cart;
import com.facilit.shoppingcart.repo.CartRepository;

@RestController
@RequestMapping("/api/v1")
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@GetMapping("/carts")
	public List<Cart> getAllCarts() {
		List<Cart> result = cartRepository.findAll();
		return result;
	}
	
	@PostMapping("/cart")
	public Cart createCart(@Valid @RequestBody Cart cart) {
		Cart saved = cartRepository.save(cart);
		return saved;
	}
}
