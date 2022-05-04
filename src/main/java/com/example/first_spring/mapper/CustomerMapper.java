package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.CustomerVO;

@Mapper
public interface CustomerMapper {
	
	public List<CustomerVO> getCustomerList();

}
