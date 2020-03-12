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
public class CouponTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void listingEmptyCouponList() throws Exception {

		this.mockMvc.perform(get("/api/v1/coupons"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$").isEmpty());

	}
	
	@Test
	public void creatingNewCoupon() throws Exception {

		String coupon = TestObjects.COUPON_01;
		
		this.mockMvc.perform(post("/api/v1/coupon")
				.content(coupon)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}

	@Test
	public void creatingNewCouponWithWrongDataType() throws Exception {

		this.mockMvc.perform(post("/api/v1/coupon")
				.content(TestObjects.COUPON_WRONG_DATA_TYPE)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void creatingNewCouponWithIncompleteData() throws Exception {

		this.mockMvc.perform(post("/api/v1/coupon")
				.content(TestObjects.COUPON_INCOMPLETE_DATA)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isUnprocessableEntity());
	}
	
	@Test
	public void listingOneSizedCouponsList() throws Exception {

		this.mockMvc.perform(post("/api/v1/coupon")
				.content(TestObjects.COUPON_01)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));

		this.mockMvc.perform(get("/api/v1/coupons"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$").isNotEmpty());

	}
}
