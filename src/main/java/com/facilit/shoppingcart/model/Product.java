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
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(exclude = "carts")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "description", nullable = false)
    private String description;
	
	@Column(name = "price", nullable = false)
    private Float price;
	
	@ManyToMany(mappedBy = "products")
	@JsonIgnoreProperties("products")
    private Set<Cart> carts = new HashSet<>();

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
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
