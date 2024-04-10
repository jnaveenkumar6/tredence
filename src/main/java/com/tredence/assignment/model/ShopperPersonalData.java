package com.tredence.assignment.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShopperPersonalData {
	
	private String shopperId;
	
	private List<Shelf> shelfs;
	
}
