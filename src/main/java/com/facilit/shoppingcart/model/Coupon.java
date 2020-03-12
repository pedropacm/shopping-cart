package com.facilit.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "coupon")
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(exclude = "carts")
public class Coupon {

	@Id
    @Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "discount", nullable = false)
    private Float discount;
	
	@ManyToMany(mappedBy = "coupons")
	@JsonIgnoreProperties("coupons")
    private Set<Cart> carts = new HashSet<>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * @param dicount the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	/**
	 * @return the carts
	 */
	public Set<Cart> getCarts() {
		return carts;
	}

	/**
	 * @param carts the carts to set
	 */
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	
	
}
