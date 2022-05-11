package com.example.first_spring.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class qureyStringVO {
	private String phone_num;
	private int age;
	private String lastName;
	private String addr;
	private Date birth_date;
}
