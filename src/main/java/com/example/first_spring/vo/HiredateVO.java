package com.example.first_spring.vo;

import lombok.Data;

@Data
public class HiredateVO {
private String ename;
private String hiredate;
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getHiredate() {
	return hiredate;
}
public void setHiredate(String hiredate) {
	this.hiredate = hiredate;
}

}
