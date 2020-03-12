package com.facilit.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cart")
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(exclude = {"coupons", "products"})
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

//	@ManyToMany(cascade = CascadeType.PERSIST)
//	@JoinTable(name = "cart_coupon",
//	joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name = "coupon_name", referencedColumnName = "name"))
//	@JsonIgnoreProperties("carts")
//	private Set<Coupon> coupons;
	
	@ElementCollection
    private List<String> coupons = new ArrayList<String>();

	@ManyToMany
	@JoinTable(name = "cart_product",
	joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	@JsonIgnoreProperties("carts")
	private Set<Product> products;

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
	 * @return the coupon
	 */
	public List<String> getCoupons() {
		return coupons;
	}

	/**
	 * @param coupon the coupon to set
	 */
	public void setCoupons(List<String> coupons) {
		this.coupons = coupons;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public Cart(List<String> coupons, Product... products) {
        if(products != null) {
        	this.products = Stream.of(products).collect(Collectors.toSet());
            this.products.forEach(x -> x.getCarts().add(this));
        }
        this.coupons = coupons;
//        if(coupons != null) {
//        	this.coupons = coupons;
//            this.coupons.forEach(x ->  x.getCarts().add(this));
//        }
    }
	
	public Cart() {}
}
