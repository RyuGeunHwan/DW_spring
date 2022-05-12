package com.example.first_spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.QureyStringService;
import com.example.first_spring.vo.qureyStringVO;

@RestController
public class QureyStringController {
	@Autowired
	private QureyStringService qss;
	
	
	@PostMapping("/privacy")
	public int callInsertVal(@RequestBody qureyStringVO vo) {
		return qss.getInsertVal(vo);
	}
	
	@DeleteMapping("/phone/num/{phone_num}")
		public int callDeletePhoneNum(@PathVariable("phone_num") String phone_num) {
			return qss.getDeletePhoneNum(phone_num);
		}
	
	@PatchMapping("/privacy")
	public int callUpdateVal(@RequestBody qureyStringVO vo) {
		return qss.getUpdateVal(vo);
	}
	
	
	@GetMapping("/privacy/age/{age}")
	public List<qureyStringVO> callGetAge(@PathVariable("age") int age){
		return qss.getAge(age);	
		}
}
