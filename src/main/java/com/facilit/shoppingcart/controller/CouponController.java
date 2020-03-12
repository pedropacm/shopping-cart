package com.facilit.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facilit.shoppingcart.model.Coupon;
import com.facilit.shoppingcart.repo.CouponRepository;

@RestController
@RequestMapping("/api/v1")
public class CouponController {

	@Autowired
	private CouponRepository couponRepository;

	@GetMapping("/coupons")
	public List<Coupon> getAllCoupons() {
		List<Coupon> result = couponRepository.findAll();
		return result;
	}
	
	@PostMapping("/coupon")
	public Coupon createCoupon(@Valid @RequestBody Coupon coupon) {
		Coupon saved = couponRepository.save(coupon);
		return saved;
	}
}
