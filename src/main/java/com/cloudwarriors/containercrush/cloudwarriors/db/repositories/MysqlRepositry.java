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
		String sqlString = "SELECT Item_Number FROM sampledb.XXIBM_PRODUCT_PRICING where PRICEID='1'";
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
			String sqlString = "select P.Item_Number,P.Description,P.Long_Description,P.Catalogue_Category,P.SKU_Unit_Of_Meaure,P.Style_Item,P.SKUAttribute1,P.SKUAttribute2,P.SKUAttribute3,P.SKUAttribute4,P.SKUAttribute5,P.SKUAttribute6,P.SKUAtt_Value1,P.SKUAtt_Value2,P.SKUAtt_Value3,P.SKUAtt_Value4,P.SKUAtt_Value5,P.SKUAtt_Value6,S.Brand,C.Segment,C.Segment_Name,C.Family,C.Family_Name,C.Class,C.Class_Name,C.Commodity,C.Commodity_Name,X.PriceID,X.List_Price,X.Discount,X.InStock,X.Price_Effective_Date from sampledb.XXIBM_PRODUCT_SKU P,sampledb.XXIBM_PRODUCT_STYLE S,sampledb.XXIBM_PRODUCT_CATALOG C,sampledb.XXIBM_PRODUCT_PRICING X where P.Style_Item=S.Item_Number and C.Commodity=S.Catalogue_Category and P.Item_Number=X.Item_Number";
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
