package com.tredence.assignment.external.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.util.StringUtils;

import com.tredence.assignment.api.exception.SearchException;
import com.tredence.assignment.entity.Product;
import com.tredence.assignment.entity.ProductMetaData;
import com.tredence.assignment.entity.ShopProduct;
import com.tredence.assignment.external.api.IExternalSearch;
import com.tredence.assignment.model.ExternalSearchResponse;
import com.tredence.assignment.repository.ProductMetaDataRepository;
import com.tredence.assignment.repository.ShopProductRepository;

public class ExternalSearchImpl implements IExternalSearch {
	
	@Autowired
	ShopProductRepository shopProductRepository;
	
	@Autowired
	ProductMetaDataRepository productMetaDataRepository;

	@Override
	public ResponseEntity<ExternalSearchResponse> searchExternalData(String shopperId, String category, String brand, Integer limit)
			throws SearchException {
		if(limit > 100) {
			throw new SearchException("Invalid Limit");
		}
		ShopProduct shopProduct = shopProductRepository.findByShopId(shopperId);
		List<String> productIdList = shopProduct.getProducts().stream()
		.map(Product::getProductId).collect(Collectors.toList());
		
		List<ProductMetaData> productMetaList = productMetaDataRepository.findAllByProductIds(productIdList, category, brand, limit);
		ExternalSearchResponse externalSearchResponse = new ExternalSearchResponse(productMetaList);
		return ResponseEntity.ok().body(externalSearchResponse);
	}

}
