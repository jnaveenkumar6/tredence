package com.tredence.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tredence.assignment.entity.ProductMetaData;

public interface ProductMetaDataRepository  extends JpaRepository<ProductMetaData, Integer>{

	@Query("SELECT DISTINCT c FROM product_meta pm \n" +
		       " WHERE (pm.product_id IN ?1) \n" +
		       " AND (?2 IS NULL OR (pm.category LIKE ?2 ))\n" +
		       " AND (?3 IS NULL OR (c.brand LIKE ?3 ))\n" +
		       " LIMIT ?4 ")
	List<ProductMetaData> findAllByProductIds(List<String> productIds, String category, String brand, Integer limit);

}
