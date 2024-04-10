package com.tredence.assignment.api.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.tredence.assignment.api.IShopperProduct;
import com.tredence.assignment.api.exception.DataSaveException;
import com.tredence.assignment.entity.Product;
import com.tredence.assignment.entity.ProductMetaData;
import com.tredence.assignment.entity.ShopProduct;
import com.tredence.assignment.model.ProductMetaDataList;
import com.tredence.assignment.model.Shelf;
import com.tredence.assignment.model.ShoppersPersonalRequest;
import com.tredence.assignment.repository.ProductMetaDataRepository;
import com.tredence.assignment.repository.ShopProductRepository;


public class ShopperProductImpl implements IShopperProduct{
	
	@Autowired
	ShopProductRepository shopProductRepository;
	
	@Autowired
	ProductMetaDataRepository productMetaDataRepository;
	

	@Override
	public ResponseEntity<String> saveShopperProducts(ShoppersPersonalRequest shoppersPersonalRequest) throws DataSaveException{
		try {
			List<ShopProduct> shoppersProducts = shoppersPersonalRequest.getShopersPersonalDataList().stream()
					.filter(shopProducts ->  !StringUtils.isNullOrEmpty(shopProducts.getShopperId()) && !CollectionUtils.isEmpty(shopProducts.getShelfs()))
					.map(shopPersonal -> {
	            return new ShopProduct(shopPersonal.getShopperId(),
	            		getProductsFromShelfs(shopPersonal.getShelfs()));
	        })
	        .collect(Collectors.toList());
			shopProductRepository.save(shoppersProducts); 
		} catch (Exception e) {
			throw new DataSaveException("Error while saving shop data");
		}
		return ResponseEntity.ok().body("SUCCESS");
	}
	
	private List<Product> getProductsFromShelfs(List<Shelf> shelfs) {
		return shelfs.stream().map(shelf-> {
			return new Product(shelf.getProductId(), shelf.getRelevancyScore());
		}).collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<String> saveProductMetaData(ProductMetaDataList productMetaDataList) throws DataSaveException {
		try {
			List<ProductMetaData> shoppersProducts = productMetaDataList.getProducts().stream()	
					.filter(metaData ->  !StringUtils.isNullOrEmpty(metaData.getProductId()))
					.map(metaData -> {
	            return new ProductMetaData(metaData.getProductId(),metaData.getCategory(),metaData.getBrand());
	        })
	        .collect(Collectors.toList());
			productMetaDataRepository.save(shoppersProducts); 
		} catch (Exception e) {
			throw new DataSaveException("Error while saving product Meta data");
		}
		return ResponseEntity.ok().body("SUCCESS");
	}

}
