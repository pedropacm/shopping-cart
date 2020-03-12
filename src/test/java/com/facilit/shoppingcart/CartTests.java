package com.facilit.shoppingcart;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;

import com.facilit.shoppingcart.util.TestObjects;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class CartTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void listingEmptyCartList() throws Exception {

		this.mockMvc.perform(get("/api/v1/carts"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$").isEmpty());

	}
	
	@Test
	public void creatingNewEmptyCart() throws Exception {

		this.mockMvc.perform(post("/api/v1/cart")
				.content(TestObjects.CART_EMPTY)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void creatingNewCartWithOneProduct() throws Exception {

		this.mockMvc.perform(post("/api/v1/product")
				.content(TestObjects.PRODUCT_A)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
		
		this.mockMvc.perform(post("/api/v1/cart")
				.content(TestObjects.CART_WITH_ONE_PRODUCT)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void listingOneSizedCartsList() throws Exception {

		this.mockMvc.perform(post("/api/v1/product")
				.content(TestObjects.PRODUCT_A)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));

		this.mockMvc.perform(post("/api/v1/cart")
				.content(TestObjects.CART_WITH_ONE_PRODUCT)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
		
		this.mockMvc.perform(get("/api/v1/carts"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$").isNotEmpty());

	}
	
	@Test
	public void creatingNewEmptyCartWithOneCoupon() throws Exception {

		this.mockMvc.perform(post("/api/v1/coupon")
				.content(TestObjects.COUPON_01)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
		
		this.mockMvc.perform(post("/api/v1/cart")
				.content(TestObjects.CART_EMPTY_WITH_ONE_COUPON)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}
}
