package com.example.first_spring.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class CustomerVO {
	private String customer_id;
	private String customer_name;
	private String grade;
	private Date create_at;
	
}
