package com.tredence.assignment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name="shop_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProduct {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "shop_id")
	private String shopId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;

	public ShopProduct(String shopId, List<Product> productsFromShelfs) {
		this.shopId = shopId ;
		this.products = productsFromShelfs;
	}

}
