package com.tredence.assignment.model;

import java.util.List;

import com.tredence.assignment.entity.ProductMetaData;

import lombok.Data;

@Data
public class ProductMetaDataList {

	private List<ProductMetaData> products;
}
