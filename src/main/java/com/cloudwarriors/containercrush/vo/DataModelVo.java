package com.cloudwarriors.containercrush.vo;

import com.cloudwarriors.containercrush.datamodels.ProductCatalog;
import com.cloudwarriors.containercrush.datamodels.ProductPricing;
import com.cloudwarriors.containercrush.datamodels.ProductSku;
import com.cloudwarriors.containercrush.datamodels.ProductStyle;

import lombok.Data;

@Data
public class DataModelVo {

	ProductCatalog productCatalog = new ProductCatalog();
	ProductPricing productPricing =  new ProductPricing();
	ProductSku productSku  =  new ProductSku();
	ProductStyle productStyle = new ProductStyle();
	
	
}
