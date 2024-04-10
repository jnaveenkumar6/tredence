package com.tredence.assignment.model;

import java.util.List;

import com.tredence.assignment.entity.ProductMetaData;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExternalSearchResponse {
	
	private List<ProductMetaData> list;

}
