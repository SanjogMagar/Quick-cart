package com.java.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.entity.Categories;

@Repository
public class CategoriesRepository {

	 @Autowired
	    private JdbcTemplate jdbctemp;
		public CategoriesRepository(JdbcTemplate jdbcTemp) {
	        this.jdbctemp = jdbcTemp;
	    }

	    // Method to save the user
	    public void saveOrder(Categories categories) {
	        String sql = "INSERT INTO categories(name, address, mobile, payment) VALUES(?, ?, ? , ? )";
	        jdbctemp.update(sql, categories.getName(), categories.getAddress(), categories.getMobile(), categories.getPayment());
	    }
}
