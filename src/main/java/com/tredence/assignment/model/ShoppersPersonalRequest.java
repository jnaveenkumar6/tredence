package com.tredence.assignment.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShoppersPersonalRequest {

	List<ShopperPersonalData> shopersPersonalDataList;

	public List<ShopperPersonalData> getShopersPersonalDataList() {
		return shopersPersonalDataList;
	}

	public void setShopersPersonalDataList(List<ShopperPersonalData> shopersPersonalDataList) {
		this.shopersPersonalDataList = shopersPersonalDataList;
	}
}
