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
	finally {
		closeResources(entityManager);
	}
	return value1;
	}
	
	public List<Object[]> retrieveProductDetails(){
		EntityManager entityManager = null;
		List<Object[]> storedProcsResults = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String sqlString = "select P.Item_Number,P.Description,P.Long_Description,P.Catalogue_Category,P.SKU_Unit_Of_Meaure,P.Style_Item,P.SKUAttribute1,P.SKUAttribute2,P.SKUAttribute3,P.SKUAttribute4,P.SKUAttribute5,P.SKUAttribute6,P.SKUAtt_Value1,P.SKUAtt_Value2,P.SKUAtt_Value3,P.SKUAtt_Value4,P.SKUAtt_Value5,P.SKUAtt_Value6,S.Brand,C.Segment,C.Segment_Name,C.Family,C.Family_Name,C.Class,C.Class_Name,C.Commodity,C.Commodity_Name,X.PriceID,X.List_Price,X.Discount,X.InStock,X.Price_Effective_Date from XXIBM_PRODUCT_SKU P,XXIBM_PRODUCT_STYLE S,XXIBM_PRODUCT_CATALOG C,XXIBM_PRODUCT_PRICING X where P.Style_Item=S.Item_Number and C.Commodity=S.Catalogue_Category and P.Item_Number=X.Item_Number;\r\n" + "";
			Query query = entityManager.createNativeQuery(sqlString);
			storedProcsResults = query.getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			closeResources(entityManager);
		}
		return storedProcsResults;
	}
	public List<Object[]> getClassGroupProducts(String individualProduct){
		EntityManager entityManager = null;
		List<Object[]> storedProcsResults = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String sqlString = "select \r\n" + 
					"P.Item_Number            ,\r\n" + 
					"P.Description            ,\r\n" + 
					"P.Long_Description       ,\r\n" + 
					"P.Catalogue_Category     ,\r\n" + 
					"P.SKU_Unit_Of_Meaure     ,\r\n" + 
					"P.Style_Item             ,\r\n" + 
					"P.SKUAttribute1          ,\r\n" + 
					"P.SKUAttribute2          ,\r\n" + 
					"P.SKUAttribute3          ,\r\n" + 
					"P.SKUAttribute4          ,\r\n" + 
					"P.SKUAttribute5          ,\r\n" + 
					"P.SKUAttribute6          ,\r\n" + 
					"P.SKUAtt_Value1          ,\r\n" + 
					"P.SKUAtt_Value2          ,\r\n" + 
					"P.SKUAtt_Value3          ,\r\n" + 
					"P.SKUAtt_Value4          ,\r\n" + 
					"P.SKUAtt_Value5          ,\r\n" + 
					"P.SKUAtt_Value6          ,\r\n" + 
					"S.Brand                  ,\r\n" + 
					"C.Segment                ,\r\n" + 
					"C.Segment_Name           ,\r\n" + 
					"C.Family                 ,\r\n" + 
					"C.Family_Name            ,\r\n" + 
					"C.Class                  ,\r\n" + 
					"C.Class_Name             ,\r\n" + 
					"C.Commodity              ,\r\n" + 
					"C.Commodity_Name         ,\r\n" + 
					"X.PriceID                ,\r\n" + 
					"X.List_Price             ,\r\n" + 
					"X.Discount               ,\r\n" + 
					"X.InStock                ,\r\n" + 
					"X.Price_Effective_Date     \r\n" + 
					"from\r\n" + 
					"XXIBM_PRODUCT_SKU P, \r\n" + 
					"XXIBM_PRODUCT_STYLE S,\r\n" + 
					"XXIBM_PRODUCT_CATALOG C,\r\n" + 
					"XXIBM_PRODUCT_PRICING X\r\n" + 
					"where\r\n" + 
					"P.Style_Item=S.Item_Number and \r\n" + 
					"C.Commodity=S.Catalogue_Category and\r\n" + 
					"P.Item_Number=X.Item_Number\r\n" + 
					"and C.Class_Name = '"+individualProduct+"'";
			Query query = entityManager.createNativeQuery(sqlString);
			storedProcsResults = query.getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			closeResources(entityManager);
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
		finally {
			closeResources(entityManager);
		}
			return storedProcsResults;
	}
	public List getClassName(String className){
		EntityManager entityManager = null;
		List storedProcsResults = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String sqlString = "SELECT DISTINCT CLASS_NAME FROM sampledb.XXIBM_PRODUCT_CATALOG WHERE FAMILY_NAME = '"+className+"'";
			Query query = entityManager.createNativeQuery(sqlString);
			storedProcsResults = query.getResultList();	
		}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		 finally {
				closeResources(entityManager);
			}
			return storedProcsResults;
	}
	
	public List<Object[]> getSingleProductDetails(String itemNumber){
		EntityManager entityManager = null;
		List<Object[]> storedProcsResults = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String sqlString = "select \r\n" + 
					"P.Item_Number            ,\r\n" + 
					"P.Description            ,\r\n" + 
					"P.Long_Description       ,\r\n" + 
					"P.Catalogue_Category     ,\r\n" + 
					"P.SKU_Unit_Of_Meaure     ,\r\n" + 
					"P.Style_Item             ,\r\n" + 
					"P.SKUAttribute1          ,\r\n" + 
					"P.SKUAttribute2          ,\r\n" + 
					"P.SKUAttribute3          ,\r\n" + 
					"P.SKUAttribute4          ,\r\n" + 
					"P.SKUAttribute5          ,\r\n" + 
					"P.SKUAttribute6          ,\r\n" + 
					"P.SKUAtt_Value1          ,\r\n" + 
					"P.SKUAtt_Value2          ,\r\n" + 
					"P.SKUAtt_Value3          ,\r\n" + 
					"P.SKUAtt_Value4          ,\r\n" + 
					"P.SKUAtt_Value5          ,\r\n" + 
					"P.SKUAtt_Value6          ,\r\n" + 
					"S.Brand                  ,\r\n" + 
					"C.Segment                ,\r\n" + 
					"C.Segment_Name           ,\r\n" + 
					"C.Family                 ,\r\n" + 
					"C.Family_Name            ,\r\n" + 
					"C.Class                  ,\r\n" + 
					"C.Class_Name             ,\r\n" + 
					"C.Commodity              ,\r\n" + 
					"C.Commodity_Name         ,\r\n" + 
					"X.PriceID                ,\r\n" + 
					"X.List_Price             ,\r\n" + 
					"X.Discount               ,\r\n" + 
					"X.InStock                ,\r\n" + 
					"X.Price_Effective_Date     \r\n" + 
					"from\r\n" + 
					"XXIBM_PRODUCT_SKU P, \r\n" + 
					"XXIBM_PRODUCT_STYLE S,\r\n" + 
					"XXIBM_PRODUCT_CATALOG C,\r\n" + 
					"XXIBM_PRODUCT_PRICING X\r\n" + 
					"where\r\n" + 
					"P.Style_Item=S.Item_Number and \r\n" + 
					"C.Commodity=S.Catalogue_Category and\r\n" + 
					"P.Item_Number=X.Item_Number\r\n" + 
					"and P.Item_Number = '"+itemNumber+"'";
			Query query = entityManager.createNativeQuery(sqlString);
			storedProcsResults = query.getResultList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			closeResources(entityManager);
		}
		return storedProcsResults;
	}
	private void closeResources(EntityManager entityManager) {

		
		try {
			if (null != entityManager)
				entityManager.close();
		} catch (Exception e) {
			
		}

	}
	
	
	
	
	
}
