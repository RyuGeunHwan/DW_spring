package com.example.first_spring.vo;

import lombok.Data;

@Data
public class DeptVO { //데이터베이스 테이블
	private int deptno;
	private String dname;
	private String loc;
}
