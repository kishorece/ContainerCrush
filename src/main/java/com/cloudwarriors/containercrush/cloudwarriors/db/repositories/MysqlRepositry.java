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
			String sqlString = "SELECT P.ITEM_NUMBER,P.DESCRIPTION,P.LONG_DESCRIPTION,P.CATALOGUE_CATEGORY,P.SKU_UNIT_OF_MEAURE,P.STYLE_ITEM,P.SKUATTRIBUTE1,P.SKUATTRIBUTE2,P.SKUATTRIBUTE3,P.SKUATTRIBUTE4,P.SKUATTRIBUTE5,P.SKUATTRIBUTE6,P.SKUATT_VALUE1,P.SKUATT_VALUE2,P.SKUATT_VALUE3,P.SKUATT_VALUE4,P.SKUATT_VALUE5,P.SKUATT_VALUE6,S.BRAND,C.SEGMENT,C.SEGMENT_NAME,C.FAMILY,C.FAMILY_NAME,C.CLASS,C.CLASS_NAME,C.COMMODITY,C.COMMODITY_NAME,X.PRICEID,X.LIST_PRICE,X.DISCOUNT,X.INSTOCK,X.PRICE_EFFECTIVE_DATE FROM XXIBM_PRODUCT_SKU P,XXIBM_PRODUCT_STYLE S,XXIBM_PRODUCT_CATALOG C,XXIBM_PRODUCT_PRICING X WHERE P.STYLE_ITEM=S.ITEM_NUMBER AND C.COMMODITY=S.CATALOGUE_CATEGORY AND P.ITEM_NUMBER=X.ITEM_NUMBER";
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
			String sqlString = "SELECT `XXIBM_PRODUCT_STYLE`.`Item_Number`,\r\n" + 
					"    `XXIBM_PRODUCT_STYLE`.`Description`,\r\n" + 
					"    `XXIBM_PRODUCT_STYLE`.`Long_Description`,\r\n" + 
					"    `XXIBM_PRODUCT_STYLE`.`Catalogue_Category`,\r\n" + 
					"    `XXIBM_PRODUCT_STYLE`.`Brand`\r\n" + 
					"FROM `sampledb`.`XXIBM_PRODUCT_STYLE`;";
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
