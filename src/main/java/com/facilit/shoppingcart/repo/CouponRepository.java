package com.facilit.shoppingcart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facilit.shoppingcart.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
