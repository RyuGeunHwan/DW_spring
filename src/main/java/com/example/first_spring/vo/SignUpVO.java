package com.example.first_spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpVO {
 private String id;
 private String pass_word;
 private String name;
 private String birthday;
 private String gender;
 private boolean isLogin;
 public SignUpVO() {
	 
 }
}
