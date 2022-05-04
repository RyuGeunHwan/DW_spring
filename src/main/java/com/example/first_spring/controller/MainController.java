package com.example.first_spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.MainService;
import com.example.first_spring.vo.UserVO;

class Count{
	private int count;
	private String menuName;
	
	
	public Count(int count, String name) {
		this.count = count;
		this.menuName = name;
	}
	public int getCount() {
		return count;
	}
}

// 어노테이션 작성 후 import(Ctrl + Shift + o) 필수!

//@Controller : url을 요청받는 곳이야~ 라고 알려주는 어노테이션!
//@RestController : 템플릿 엔진을 사용하지 않을 때는 앞에 Rest를 써주어야한다.

@RestController
public class MainController {
	
	@Autowired
	private MainService service;
	// 1. MainService클래스는 비즈니스로직을 구현하는 @Service 어노테이션이 있기 때문에
	// 2. 추가로 호출하는 곳에 @Autowired 어노테이션이 작성되어 있어야한다.
	// 두가지가 충족 된다면 Controller에서 따로 호출(new)하지 않고 필드변수로 선언 후 사용 가능!
	// (@Autowired Spring이 해당 객체(클래스)를 관리해줌. IoC(Inversion of Conrtol)

	
	@GetMapping(value = {"/", "/index", "/main"}) //http://localhost:8080/index , localhost : 본인 IP주소를 의미함
	 // index라는 주소를 요청하면 call() 메소드를 실행할게~
	public String call() {
		String word = "류그화니 오늘도 화이팅하자!";
		return word;
	}
	
	// @Mapping : Mapping앞에 Get,POST,PUT,DELETE 등이 올 수 있다.
	// "/sum" : 주소 값(Value)
	@GetMapping("/sum") //http://localhost:8080/sum , localhost : 본인 IP주소를 의미함
	 // sum이라는 주소를 요청하면 callSum() 메소드를 실행할게~
	public int callSum() {
		return service.COUNT;
		// @Service어노테이션 클래스인 service(MainService class == Model)의 필드변수 COUNT를 return하여
		// @Controller가 View한테 전송
	}
	@GetMapping("/count")
	public int menuName() {
		Count c= new Count(5 , "짬뽕");
		c.getCount();
		return c.getCount();
	}
	
	@GetMapping("/userList")
	public List<UserVO> callUserList(){
		return service.getUserList();//service.getUserList()를 사용할 수 있는것
				// @Autowired
				// private MainService service;
	}


}
