package com.cloudwarriors.containercrush.datamodels;

import lombok.Data;

@Data
public class ProductPricing {

	private int priceID;
	private int itemNumber;
	private double listPrice;
	private double discount;
	private String inStock;
	private String priceEffectiveDate;
}
