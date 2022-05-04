package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first_spring.vo.UserVO;

@Service 
// @Service에서 로직을 구현한다.
//Model에 비즈니스 로직이 있겠구나 알려주는 어노테이션
public class MainService {
	public final int COUNT = 15;
	 //문제 1. 나이가 60 이하인 배우만 리턴하시오.
    public List<UserVO> getUserList(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        
        //방법1. 60세 이상의 index를 새로운 List(=list1)에 넣어버리기
        List<UserVO> list1 = new ArrayList<UserVO>(); 
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i).getAge()<=60) {
        		list1.add(new UserVO(list.get(i).getName(),list.get(i).getAge(),list.get(i).getAddr()));
        	}
        	
        }
		return list1;// 60세 이상을 넣어준 List를 return
		
		
        //방법2. 60세가 이상 index지워버리기
//        for(int i=0; i<list.size(); i++) {
//        	 if(list.get(i).getAge()>=60) {
//         		list.remove(i);
//         		i--;
//			// i--사용 이유는 컬렉션즈의 특징으로 인덱스를 삭제하게 되면 뒤에있는 인덱스가 삭제된 공간을 채우기 때문에
//			// if문이 실행되었으면 삭제된 공간에 채워진 index를 다시 한번 확인 하기 위해 사용된 것이다.
//			// if문이 충족되지 않을경우 i는 list.size()가 될때까지 증감(++)하기 때문에!
//         	}
//        }
//		return list; //기존 인덱스에서 60세이상을 삭제하고 기존 list return
	}
    //문제 2. 나이가 가장많은 배우의 나이를 리턴하시오.
    public int getUserAgeMax(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        int age = 0;
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i).getAge()>age) {
        		age = list.get(i).getAge();
        	}
        }
		return age;
	}
    //문제 3. list에 배우이름 배성우가 있다면 리턴하시오.
    public UserVO getUser(){
    	UserVO vo = null;
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i).getName().equals("배성우")) {
        		vo = list.get(i);
        	}
        }
		return vo;
	}
    //문제 4. list에 성이 이씨인 배우가 몇명인지 리턴하시오.
    public int getUserCount(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        int count = 0;
        for(int i=0; i<list.size(); i++) {
        	String name = list.get(i).getName();
        	if(name.substring(0, 1).equals("이")) {
        		count++;
        	}
        }
		return count;
	}
}
