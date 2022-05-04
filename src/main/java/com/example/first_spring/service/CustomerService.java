package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.CustomerMapper;
import com.example.first_spring.vo.CustomerVO;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<CustomerVO> getCustomerList(){
		return customerMapper.getCustomerList();
	}
	

}
