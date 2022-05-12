package com.example.first_spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.qureyStringVO;

@Mapper
public interface QureyStringMapper {
	public int getInsertVal(qureyStringVO vo);
	
	public int deletephoneNum(String phone_num);
	
	public int updateVal(qureyStringVO vo);
	
	public List<qureyStringVO> getAge(int age);
}
