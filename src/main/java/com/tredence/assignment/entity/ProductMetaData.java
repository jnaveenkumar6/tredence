package com.tredence.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="product_meta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMetaData {
	@Id
	@GeneratedValue
	private Integer meta_id;
	
	@Column(name = "product_id")
	private String productId;
	@Column
	private String category;
	@Column
	private String brand;
	
	public ProductMetaData(String productId, String category, String brand) {
		this.productId = productId;
		this.category = category;
		this.brand = brand;
	}
}
