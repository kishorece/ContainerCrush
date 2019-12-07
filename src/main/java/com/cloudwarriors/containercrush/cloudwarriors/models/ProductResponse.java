package com.cloudwarriors.containercrush.cloudwarriors.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ProductResponse {
	
	private List<ProductDetailResponse> plannedEvents = new ArrayList<ProductDetailResponse>();

}
