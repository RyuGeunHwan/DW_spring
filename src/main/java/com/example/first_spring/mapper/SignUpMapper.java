package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.first_spring.vo.SignUpVO;
@Mapper
public interface SignUpMapper {
	
	public List<SignUpVO> getSignUpVO();
	
	public int postValue(SignUpVO vo);
	
	public int patchIsLogin(@Param("firstPassword") String firstPassword, @Param("isLogin") String isLogin);
}
