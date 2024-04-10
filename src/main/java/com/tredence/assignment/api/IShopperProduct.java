package com.tredence.assignment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tredence.assignment.api.exception.DataSaveException;
import com.tredence.assignment.model.ProductMetaDataList;
import com.tredence.assignment.model.ShoppersPersonalRequest;


@RestController
@RequestMapping(value = "/internal")
public interface IShopperProduct {

	@PostMapping(value = "/shopper")
	public ResponseEntity<String> saveShopperProducts(ShoppersPersonalRequest shoppersPersonalRequest) throws DataSaveException;

	@PostMapping(value = "/meta-data")
	public ResponseEntity<String> saveProductMetaData(ProductMetaDataList productMetaDataList) throws DataSaveException;
	
	
}
