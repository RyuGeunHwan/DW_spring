package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.SalGradeService;
import com.example.first_spring.vo.SalGradeVO;

@RestController
public class SalGradeController {

	
	@Autowired
	private SalGradeService salGradeService;
	
	@GetMapping("/salGrade/grade/{grade}")
	public List<SalGradeVO> loadSalGrade(@PathVariable("grade")int grade){
		return salGradeService.getSalGradeList(grade);
	}
}
