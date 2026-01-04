package com.java.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.entity.Products;

@Repository
public class ProductRepository {

	 @Autowired
	 private final JdbcTemplate jdbctemp;
		public ProductRepository(JdbcTemplate jdbcTemp) {
	        this.jdbctemp = jdbcTemp;
	    }

	    
	    public void saveProducts(Products product) {
	        String sql = "INSERT INTO sellproduct (name, category, description, price, companyname) VALUES (?, ?, ?, ?, ?)";
	        jdbctemp.update(sql, product.getName(), product.getCategory(), product.getDescription(), product.getPrice(), product.getCompanyname());
	    }
}
