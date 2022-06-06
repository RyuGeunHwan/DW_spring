package com.example.first_spring.vo;

import lombok.Data;

@Data
public class EmpVO extends DeptVO {
	private String ename;
	private int sal;
	private int empno;
	private String job;
	private String hiredate;
	private int comm;
	private int mgr;
	private int deptno;

	
}
