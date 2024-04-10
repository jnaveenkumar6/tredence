package com.tredence.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	public Product(String productId, Double relevancyScore) {
		this.productId = productId;
		this.relevancyScore = relevancyScore;
		
	}
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "product_id")
	private String productId;
    
	@Column(name = "relevancy_score")
	private Double relevancyScore;
	
	// Mapping the column of this table 
    @ManyToOne
    //Adding the name
    @JoinColumn(name = "shop_id")
    ShopProduct shopProduct;
   
}
