package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.SignUpService;
import com.example.first_spring.vo.SignUpVO;

@RestController
public class SignUpController {

	@Autowired
	private SignUpService sService;
	
	//@CrossOrigin : 입력해주지 않으면 CORS라는 에러 발생! jquery 200이라는 에러메세지 발생!
	@CrossOrigin(origins = {"*"})
	@GetMapping("/signUp")
	public List<SignUpVO> callSignUpVO(){
		return sService.getSignUpVO();
	}
	
	@CrossOrigin(origins = {"*"})
	@PostMapping("/signUp")
	public int insertSignUpVO(@RequestBody SignUpVO vo) {
		int rows = sService.postValue(vo);
		return rows;
	}
	
	@CrossOrigin(origins = {"*"})
	//localhost:8080/signUp?gender=M
	@PatchMapping("/signUp")
	public int callPatchIsLogin(
			@RequestParam("firstPassword") String firstPassword, 
			@RequestParam("isLogin") String isLogin
			) {
		return sService.patchIsLogin(firstPassword,isLogin);
	}
}
