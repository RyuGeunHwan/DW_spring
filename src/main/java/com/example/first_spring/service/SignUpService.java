package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.SignUpMapper;
import com.example.first_spring.vo.SignUpVO;

@Service
public class SignUpService {
	@Autowired
	private SignUpMapper sMapper;
	
	public List<SignUpVO> getSignUpVO(){
		return sMapper.getSignUpVO();
	}
	
	public int postValue(SignUpVO vo) {
		int rows = sMapper.postValue(vo);
		return rows;
	}
	
	public int patchIsLogin(String firstPassword, String isLogin) {
		System.out.println(firstPassword + isLogin);
		int rows = sMapper.patchIsLogin(firstPassword,isLogin);
		return rows;
	}
}
