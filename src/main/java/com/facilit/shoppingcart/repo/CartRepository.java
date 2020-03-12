package com.facilit.shoppingcart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facilit.shoppingcart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
