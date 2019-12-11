package com.cloudwarriors.containercrush.cloudwarriors.db.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlRepositry {
	@Autowired
	@Qualifier(value = "entityManagerFactory")
	EntityManagerFactory entityManagerFactory;
	
	public String getSampleDataFromMysql() {
	EntityManager entityManager = null;
	String decodeCodeDescText = null;
	Integer value;
	String value1= null;
	try {
		entityManager = entityManagerFactory.createEntityManager();
		String sqlString = "SELECT Item_Number FROM XXIBM_PRODUCT_PRICING where PriceID='1'";
		Query query = entityManager.createNativeQuery(sqlString);
		value = (Integer)query.getSingleResult();
		value1 = String.valueOf(value);
				
		
	}
	catch(Exception e){
		e.printStackTrace();
		value1 = "The query didnt execute";
	}
	return value1;
	}
	
	public List<Object[]> retrieveProductDetails(){
		EntityManager entityManager = null;
		List<Object[]> storedProcsResults = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String sqlString ="SELECT P.ITEM_NUMBER,P.DESCRIPTION,P.LONG_DESCRIPTION,P.CATALOGUE_CATEGORY,P.SKU_UNIT_OF_MEASURE,P.STYLE_ITEM,P.SKU_ATTRIBUTE1,P.SKU_ATTRIBUTE2,P.SKU_ATTRIBUTE3,P.SKU_ATTRIBUTE4,P.SKU_ATTRIBUTE5,P.SKU_ATTRIBUTE6,P.SKU_ATTRIBUTE_VALUE1,P.SKU_ATTRIBUTE_VALUE2,P.SKU_ATTRIBUTE_VALUE3,P.SKU_ATTRIBUTE_VALUE4,P.SKU_ATTRIBUTE_VALUE5,P.SKU_ATTRIBUTE_VALUE6,S.BRAND,C.SEGMENT,C.SEGMENT_NAME,C.FAMILY,C.FAMILY_NAME,C.CLASS,C.CLASS_NAME,C.COMMODITY,C.COMMODITY_NAME,X.PRICE_ID,X.LIST_PRICE,X.DISCOUNT,X.IN_STOCK,X.PRICE_EFFECTIVE_DATE FROM XXIBM_PRODUCT_SKU P,XXIBM_PRODUCT_STYLE S,XXIBM_PRODUCT_CATALOGUE C,XXIBM_PRODUCT_PRICING X WHERE P.STYLE_ITEM=S.ITEM_NUMBER AND C.COMMODITY=S.CATALOGUE_CATEGORY AND P.ITEM_NUMBER=X.ITEM_NUMBER";
			Query query = entityManager.createNativeQuery(sqlString);
			storedProcsResults = query.getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return storedProcsResults;
	}
	
	public List<Object[]> retrieveProducts(){
		EntityManager entityManager = null;
		List<Object[]> storedProcsResults = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String sqlString = "SELECT `XXIBM_PRODUCT_CATALOG`.`Segment`,\r\n" + 
					"    `XXIBM_PRODUCT_CATALOG`.`Segment_Name`,\r\n" + 
					"    `XXIBM_PRODUCT_CATALOG`.`Family`,\r\n" + 
					"    `XXIBM_PRODUCT_CATALOG`.`Family_Name`,\r\n" + 
					"    `XXIBM_PRODUCT_CATALOG`.`Class`,\r\n" + 
					"    `XXIBM_PRODUCT_CATALOG`.`Class_Name`,\r\n" + 
					"    `XXIBM_PRODUCT_CATALOG`.`Commodity`,\r\n" + 
					"    `XXIBM_PRODUCT_CATALOG`.`Commodity_Name`\r\n" + 
					"FROM `sampledb`.`XXIBM_PRODUCT_CATALOGUE`;";
			Query query = entityManager.createNativeQuery(sqlString);
			storedProcsResults = query.getResultList();	
		}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return storedProcsResults;
	}
	
	
	
}
