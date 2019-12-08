package com.cloudwarriors.containercrush.cloudwarriors.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwarriors.containercrush.cloudwarriors.db.repositories.MysqlRepositry;
import com.cloudwarriors.containercrush.cloudwarriors.models.ProductResponse;
import com.cloudwarriors.containercrush.service.ProductDetailsService;

@RestController
public class ControllerCrushController {
	@Autowired
	MysqlRepositry sqlRepositry;
	@Autowired
	ProductDetailsService detailsService;
	@GetMapping(value = "/status", produces = "text/plain")
	public String homePage() {
		String xx = sqlRepositry.getSampleDataFromMysql();
		return xx;
	}
	@GetMapping(value = "/details", produces = "application/json")
	public ResponseEntity getAllProductDetails(){
		ProductResponse response = new ProductResponse();
		ProductResponse response1 = detailsService.getBasicProductDetails(response);
		return new ResponseEntity<>(response1,HttpStatus.OK);
		
		
	}
	@GetMapping(value = "/product", produces = "application/json")
	public ResponseEntity getAllProduct(){
		
		List<Object[]> storedProcedure = sqlRepositry.retrieveProducts();
		return new ResponseEntity<>(storedProcedure,HttpStatus.OK);
		
		
	}
	
	}  

