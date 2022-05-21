package com.example.first_spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;


// getter,setter or data : getter,setter함수를 자동으로 만들어 줌
@Data
@AllArgsConstructor // 생성자를 자동으로 만들고 생성자의 파라미터에 필드변수만큼 자동으로 추가
public class UserVO {
	private String name;
	private int age;
	private String addr;
<<<<<<< HEAD
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public UserVO(String name,int age,String addr) {
=======
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public UserVO(String name, int age,String addr) {
>>>>>>> f7fc534614d5af9e09afaa0d87b39212e65a3cbb
	}

	

	
}


