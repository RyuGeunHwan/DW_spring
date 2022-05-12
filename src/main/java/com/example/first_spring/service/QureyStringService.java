package com.example.first_spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.QureyStringMapper;
import com.example.first_spring.vo.qureyStringVO;

@Service
public class QureyStringService {
	@Autowired
	private QureyStringMapper qsm;
	
	
	@Transactional(rollbackFor = {Exception.class})
	public int getInsertVal(qureyStringVO vo) {
		int rows = qsm.getInsertVal(vo);
		return rows;
	}
	@Transactional(rollbackFor = {Exception.class})
	public int getDeletePhoneNum(String phone_num) {
		int rows = qsm.deletephoneNum(phone_num);
		return rows;
	}
	@Transactional(rollbackFor = {Exception.class})
	public int getUpdateVal(qureyStringVO vo) {
		int rows = qsm.updateVal(vo);
		return rows;
	}
	@Transactional(rollbackFor = {Exception.class})
	public List<qureyStringVO> getAge(int age){ //age : 10
		List<qureyStringVO> list = null;
		for(int i=0; i<qsm.getAge(age).size(); i++) {
			if(qsm.getAge(age).get(i).getAge() >= age) {
				list = qsm.getAge(age);
			}
		}
		return list;
	}
}
