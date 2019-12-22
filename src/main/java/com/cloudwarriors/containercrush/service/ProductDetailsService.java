package com.cloudwarriors.containercrush.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cloudwarriors.containercrush.cloudwarriors.db.repositories.MysqlRepositry;
import com.cloudwarriors.containercrush.cloudwarriors.models.ClassResponse;
import com.cloudwarriors.containercrush.cloudwarriors.models.ProductClassResponse;
import com.cloudwarriors.containercrush.cloudwarriors.models.ProductDetailResponse;
import com.cloudwarriors.containercrush.cloudwarriors.models.ProductResponse;
import com.cloudwarriors.containercrush.cloudwarriors.models.ProductSingleResponse;
import com.cloudwarriors.containercrush.cloudwarriors.models.SingleResponse;
import com.cloudwarriors.containercrush.vo.DataModelVo;

@Component
public class ProductDetailsService {

	@Autowired
	MysqlRepositry sqlRepositry;

	public ProductResponse getBasicProductDetails(String individualProducts,ProductResponse outputResponse) {
		List<Object[]> storedProcsResults = sqlRepositry.getClassGroupProducts(individualProducts);
		List<ProductDetailResponse> l1 = new ArrayList<ProductDetailResponse>();
		if (storedProcsResults != null && !storedProcsResults.isEmpty()) {
			for (int i = 0; i < storedProcsResults.size(); i++) {

				try {
					ProductDetailResponse response = new ProductDetailResponse();
					Object[] firstResult = storedProcsResults.get(i);
					if (firstResult[0] != null) {
						response.setItemNumber(firstResult[0].toString());
					}
					if (firstResult[1] != null) {
						response.setDescription(firstResult[1].toString());
					}
					if (firstResult[2] != null) {
						response.setLongDescription(firstResult[2].toString());
					}
					if (firstResult[3] != null) {
						response.setCatalogueCatergory(firstResult[3].toString());
					}
					if (firstResult[4] != null) {
						response.setSkuUnitOfMeaure(firstResult[4].toString());
					}
					if (firstResult[5] != null) {
						response.setStyleItem(firstResult[5].toString());
					}
					if (firstResult[6] != null) {
						response.setSKUAttribute1(firstResult[6].toString());
					}
					if (firstResult[7] != null) {
						response.setSKUAttribute2(firstResult[7].toString());
					}
					if (firstResult[8] != null) {
						response.setSKUAttribute3(firstResult[8].toString());
					}
					if (firstResult[9] != null) {
						response.setSKUAttribute4(firstResult[9].toString());
					}
					if (firstResult[10] != null) {
						response.setSKUAttribute5(firstResult[10].toString());
					}
					if (firstResult[11] != null) {
						response.setSKUAttribute6(firstResult[11].toString());
					}
					if (firstResult[12] != null) {
						response.setSKUAttValue1(firstResult[12].toString());
					}
					if (firstResult[13] != null) {
						response.setSKUAttValue2(firstResult[13].toString());
					}
					if (firstResult[14] != null) {
						response.setSKUAttValue3(firstResult[14].toString());
					}
					if (firstResult[15] != null) {
						response.setSKUAttValue4(firstResult[15].toString());
					}
					if (firstResult[16] != null) {
						response.setSKUAttValue5(firstResult[16].toString());
					}
					if (firstResult[17] != null) {
						response.setSKUAttValue6(firstResult[17].toString());
					}
					if (firstResult[18] != null) {
						response.setBrand(firstResult[18].toString());
					}
					if (firstResult[19] != null) {
						response.setSegment(firstResult[19].toString());
					}
					if (firstResult[20] != null) {
						response.setSegmentName(firstResult[20].toString());
					}
					if (firstResult[21] != null) {
						response.setFamily(firstResult[21].toString());
					}
					if (firstResult[22] != null) {
						response.setFamilyName(firstResult[22].toString());
					}
					if (firstResult[23] != null) {
						response.setClassType(firstResult[23].toString());
					}
					if (firstResult[24] != null) {
						response.setClassName(firstResult[24].toString());
					}
					if (firstResult[25] != null) {
						response.setCommodity(firstResult[25].toString());
					}
					if (firstResult[26] != null) {
						response.setCommodityName(firstResult[26].toString());
					}
					if (firstResult[27] != null) {
						response.setPriceID(firstResult[27].toString());
					}
					if (firstResult[28] != null) {
						response.setListPrice(firstResult[28].toString());
					}
					if (firstResult[29] != null) {
						response.setDiscount(firstResult[29].toString());
					}
					if (firstResult[30] != null) {
						response.setInStock(firstResult[30].toString());
					}
					if (firstResult[31] != null) {
						response.setPriceEffectiveDate(firstResult[31].toString());
					}

					l1.add(response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			outputResponse.setPlannedEvents(l1);

		}
		return outputResponse;

	}

	public ProductClassResponse getBasicProductDetails(String className,ProductClassResponse output) {
		List<ClassResponse> l1 = new ArrayList<ClassResponse>();

		List storedProcsResults = sqlRepositry.getClassName(className);
		if (storedProcsResults != null && !storedProcsResults.isEmpty()) {
			for (int i = 0; i < storedProcsResults.size(); i++) {

				try {
					String firstResult = (String) storedProcsResults.get(i);
					ClassResponse response  = new ClassResponse();
					if (firstResult!= null) {
						
						response.setClassName(firstResult);
					}
					l1.add(response);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			output.setClassDetails(l1);
			

		}
		return output;
	}
	
	public ProductSingleResponse getSingleProductDetails(String singleProducts,ProductSingleResponse outputResponse) {
		List<Object[]> storedProcsResults = sqlRepositry.getSingleProductDetails(singleProducts);
		List<SingleResponse> l1 = new ArrayList<SingleResponse>();
		if (storedProcsResults != null && !storedProcsResults.isEmpty()) {
			
				try {
					SingleResponse response = new SingleResponse();
					Object[] firstResult = storedProcsResults.get(0);
					if (firstResult[0] != null) {
						response.setItemNumber(firstResult[0].toString());
					}
					if (firstResult[1] != null) {
						response.setDescription(firstResult[1].toString());
					}
					if (firstResult[2] != null) {
						response.setLongDescription(firstResult[2].toString());
					}
					if (firstResult[3] != null) {
						response.setCatalogueCategory(firstResult[3].toString());
					}
					if (firstResult[4] != null) {
						response.setSkuUnitOfMeasure(firstResult[4].toString());
					}
					if (firstResult[5] != null) {
						response.setStyleItem(firstResult[5].toString());
					}
					if (firstResult[6] != null) {
						response.setSkuAttribute1(firstResult[6].toString());
					}
					if (firstResult[7] != null) {
						response.setSkuAttribute2(firstResult[7].toString());
					}
					if (firstResult[8] != null) {
						response.setSkuAttribute3(firstResult[8].toString());
					}
					if (firstResult[9] != null) {
						response.setSkuAttribute4(firstResult[9].toString());
					}
					if (firstResult[10] != null) {
						response.setSkuAttribute5(firstResult[10].toString());
					}
					if (firstResult[11] != null) {
						response.setSkuAttribute6(firstResult[11].toString());
					}
					if (firstResult[12] != null) {
						response.setSkuValue1(firstResult[12].toString());
					}
					if (firstResult[13] != null) {
						response.setSkuValue2(firstResult[13].toString());
					}
					if (firstResult[14] != null) {
						response.setSkuValue3(firstResult[14].toString());
					}
					if (firstResult[15] != null) {
						response.setSkuValue4(firstResult[15].toString());
					}
					if (firstResult[16] != null) {
						response.setSkuValue5(firstResult[16].toString());
					}
					if (firstResult[17] != null) {
						response.setSkuValue6(firstResult[17].toString());
					}
					if (firstResult[18] != null) {
						response.setBrand(firstResult[18].toString());
					}
					if (firstResult[19] != null) {
						response.setSegment(firstResult[19].toString());
					}
					if (firstResult[20] != null) {
						response.setSegmentName(firstResult[20].toString());
					}
					if (firstResult[21] != null) {
						response.setFamily(firstResult[21].toString());
					}
					if (firstResult[22] != null) {
						response.setFamilyName(firstResult[22].toString());
					}
					if (firstResult[23] != null) {
						response.setClassType(firstResult[23].toString());
					}
					if (firstResult[24] != null) {
						response.setClassName(firstResult[24].toString());
					}
					if (firstResult[25] != null) {
						response.setCommodity(firstResult[25].toString());
					}
					if (firstResult[26] != null) {
						response.setCommodityName(firstResult[26].toString());
					}
					if (firstResult[27] != null) {
						response.setPriceId(firstResult[27].toString());
					}
					if (firstResult[28] != null) {
						response.setListPrice(firstResult[28].toString());
					}
					if (firstResult[29] != null) {
						response.setDiscount(firstResult[29].toString());
					}
					if (firstResult[30] != null) {
						response.setInStock(firstResult[30].toString());
					}
					if (firstResult[31] != null) {
						response.setPriceEffectiveDate(firstResult[31].toString());
					}

					l1.add(response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			outputResponse.setSingleProduct(l1);
			return outputResponse;

	}
	
	
}
