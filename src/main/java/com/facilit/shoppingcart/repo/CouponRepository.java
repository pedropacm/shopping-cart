package com.facilit.shoppingcart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facilit.shoppingcart.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

//	@Query("SELECT 1 * FROM Coupon c WHERE LOWER(c.name) = LOWER(:name) LIMIT 1")
//    public Coupon findCoupon(@Param("name") String name);
}
