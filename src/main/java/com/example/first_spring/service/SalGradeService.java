package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.SalGradeMapper;
import com.example.first_spring.vo.SalGradeVO;

@Service
public class SalGradeService {
	
	@Autowired
	private SalGradeMapper salGradeMapper;
	
	public List<SalGradeVO> getSalGradeList(int grade){
		return salGradeMapper.getSalGradeList(grade);
	}

}
