package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.CustomerService;
import com.example.first_spring.vo.CustomerVO;

@RestController
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/customer")
	public List<CustomerVO> callCustomerVo(){
		return customerService.getCustomerList();
	}

}
