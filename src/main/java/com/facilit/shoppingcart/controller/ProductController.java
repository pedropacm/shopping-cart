package com.facilit.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facilit.shoppingcart.repo.ProductRepository;
import com.facilit.shoppingcart.model.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> getAllUsers() {
		List<Product> result = productRepository.findAll();
		return result;
	}

	@PostMapping("/product")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}
}
