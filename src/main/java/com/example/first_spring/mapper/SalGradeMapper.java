package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.SalGradeVO;

@Mapper
public interface SalGradeMapper {

	public List<SalGradeVO> getSalGradeList(int grade);
	
}
