package com.cloudwarriors.containercrush.datamodels;

import lombok.Data;

@Data
public class ProductCatalog {
	private int segment;
	private String segmentName;
	private int family;
	private String familyName;
	private int classType;
	private String className;
	private int commodity;
	private String commodityName;
}
