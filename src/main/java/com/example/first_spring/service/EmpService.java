package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.CommVO;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.EnameVO;
import com.example.first_spring.vo.HiredateVO;

@Service
public class EmpService {
	@Autowired
	private EmpMapper empMapper;
	
	public List<EmpVO> getAllempList(){
		return empMapper.getEmpList();
	}
	public EmpVO getEmp(int empNo) {
		return empMapper.getEmp(empNo);
	}
	public List<EmpVO> selectEmpWhereJobAndSal(String jobName, int sal){
		if(jobName.equals("SALESMAN")) {
			return null;
		}
		return empMapper.selectEmpWhereJobAndSal(jobName, sal);
	}

	
	public List<EnameVO> getEmpEname() {
		return empMapper.getEmpEname();
	}

	public List<CommVO> getEmpComm(){
		return empMapper.getEmpComm();
	}
	public List<HiredateVO> getEmpHiredate(){
		return empMapper.getEmpHiredate();
	}
	
	//문제 0. 급여 1500을 파라미터로 받고 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
	public List<EmpVO> getEmpDeptNo(int sal){
		return empMapper.getEmpDeptNo(sal);
	}
	//문제 1. emp에서 사수가 없는 사원 조회
	public List<EmpVO> getMgr(){
		return empMapper.getMgr();
	}
	//문제 2. 1987년에 입사한 사원 수가 3명 이하면 1981년에 입사한 사원으로 조회하시오.
	public List<EmpVO> getHiredateYear(String year){
		int count = 0;
		for(int i=0; i<empMapper.getHiredateYear(year).size(); i++) {
			count++;
		}
		if(count <= 3) {
			year = "1981";
			return empMapper.getHiredateYear(year);
		}
		return empMapper.getHiredateYear(year);
	}
	//문제 3. 급여가 가장 높은 사원 조회
	public List<EmpVO> getHiredateMonth(String month){
		int maxSal = 0;
		List<EmpVO> list = new ArrayList<EmpVO>();
		list = empMapper.getHiredateMonth(month);
		System.out.println(list);
		for(int i=0; i<list.size(); i++) {
			if(maxSal<list.get(i).getSal()){
				maxSal = empMapper.getHiredateMonth(month).get(i).getSal();
			}
		}
		for(int i=0; i<list.size(); i++) {
			if(maxSal == list.get(i).getSal()) {
				System.out.println(empMapper.getHiredateMonth(month));
				return list;
			}
		}
		return list;
	}
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	public List<EmpVO> getJob(String jobName){
		return empMapper.getJob(jobName);
	}
}
