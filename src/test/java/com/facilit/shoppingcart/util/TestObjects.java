package com.facilit.shoppingcart.util;

public class TestObjects {

	public static final String PRODUCT_A = "{\"name\":\"Product A\",\"description\":\"Testing A\",\"price\":1.0}";
	public static final String PRODUCT_WRONG_DATA_TYPE = "{\"name\":\"Product A\",\"description\":\"Testing A\",\"price\":\"1.o\"}";
	public static final String PRODUCT_INCOMPLETE_DATA = "{\"name\":\"Product A\",\"description\":\"Testing A\"}";
	
	public static final String COUPON_01 = "{\"name\":\"coupon01\",\"discount\":0.5}";
	public static final String COUPON_WRONG_DATA_TYPE = "{\"name\":\"coupon01\",\"discount\":\"o.5\"}";
	public static final String COUPON_INCOMPLETE_DATA = "{\"name\":\"coupon01\"}";
	
	public static final String CART_EMPTY = "{}";
	public static final String CART_EMPTY_WITH_ONE_COUPON = "{\"coupons\":[\"coupon01\"]}";
	public static final String CART_WITH_ONE_PRODUCT = "{\"products\":[{\"id\":1}]}";
}
