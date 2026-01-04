package com.java.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.entity.Contact;

@Repository
public class ContactRepository {
	
	private final JdbcTemplate jdbctemp;
	public ContactRepository(JdbcTemplate jdbcTemp) {
        this.jdbctemp = jdbcTemp;
    }
	
	public void saveUser(Contact user) {
		String sql = "INSERT INTO contact (name, email, number, message) VALUES (?, ?, ?, ?)";
		jdbctemp.update(sql, user.getName(), user.getEmail(), user.getNumber(), user.getMessage());
	}

}
