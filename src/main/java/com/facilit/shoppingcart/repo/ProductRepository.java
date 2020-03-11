package com.facilit.shoppingcart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facilit.shoppingcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
