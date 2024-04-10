package com.tredence.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tredence.assignment.entity.ShopProduct;

public interface ShopProductRepository  extends JpaRepository<ShopProduct, Integer>{

	ShopProduct findByShopId(String shopperId);

}
