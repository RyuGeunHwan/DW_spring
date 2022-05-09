package com.example.first_spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.CommVO;
import com.example.first_spring.vo.DeptVO;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.EnameVO;
import com.example.first_spring.vo.HiredateVO;

@RestController
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@GetMapping("/emp")
	public List<EmpVO> callEmpList(HttpServletRequest request){
		String ip = request.getHeader("X-Forwarded-For");
	    if (ip == null) ip = request.getRemoteAddr();
	    System.out.println("IP ====> "+ip);
		return empService.getAllempList();
	}
	

	// @PathVariable : {}로 들어온 값을 파라미터에 대입
	@GetMapping("/emp/no/{empNo}")
	public EmpVO callEmp(@PathVariable("empNo") int empNo) {
		return empService.getEmp(empNo);
	}
	
	//문제. job이 manager이고 sal이 2500이상받는 사원comm을 500으로 업데이트 후
	// 사원이름,직업,커미션 조회
	@GetMapping("/emp/job/{jobName}/sal/{sal}")
	public List<EmpVO> selectEmpWhereJobAndSal(@PathVariable("jobName") String jobName, @PathVariable("sal") int sal){
		return empService.selectEmpWhereJobAndSal(jobName, sal);
	}
	
	@GetMapping("/emp/name")
	public List<EnameVO> callEmpEname() {
		System.out.println("이름에 L문자가 두 번 이상 포함된 사원 "+empService.getEmpEname());
		return empService.getEmpEname();
	}
	@GetMapping("/emp/comm")
	public List<CommVO> callEmpComm(){
		System.out.println("보너스가 없는 놈은 "+empService.getEmpComm());
		return empService.getEmpComm();
	}
	
	@GetMapping("/emp/hiredate")
	public List<HiredateVO> callEmpHiredate(){
		System.out.println("입사일 : '1980-12-17' ~ '1982-01-23' "+empService.getEmpHiredate());
		return empService.getEmpHiredate();
	}
	
	//문제 0. 급여 1500을 파라미터로 받고 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
	@GetMapping("/emp/sal/{sal}")
	public List<EmpVO> callSal(@PathVariable("sal") int sal){
		return empService.getEmpDeptNo(sal);
	}
	//문제 1. emp에서 사수가 없는 사원 조회
	@GetMapping("/emp/mgr")
	public List<EmpVO> callMgr(){
		return empService.getMgr();
	}
	
	//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회 
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> callHiredateYear(@PathVariable("year") String year){
		return empService.getHiredateYear(year);
	}
	
	//문제 3. 12월을 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	@GetMapping("/emp/hiredate/month/{month}")
	public List<EmpVO> callHiredateMonth(@PathVariable("month") String month){
		return empService.getHiredateMonth(month);
	}
	
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	@GetMapping("/emp/job/{jobName}")
	public List<EmpVO> callJob(@PathVariable("jobName") String jobName){
		return empService.getJob(jobName);
	}
	
	
	
	// @RequestBody가 파라미터로 넘어오는 VO클래스를 대신 new해줌.
	// http요청의 body 부분을 java 객체로 받을 수 있게 해주는 어노테이션. 주로 json을 받을 때 활용 
	//@PostMapping : 데이터 insert
	@PostMapping("/emp")
	public int callEmpSet(@RequestBody EmpVO empVO) {
		return empService.setEmp(empVO);
	}
	
	//@DeleteMapping : 데이터 delete
	@DeleteMapping("/emp/empno/{empno}")
	public int callEmpRemove(@PathVariable("empno") int empNo) {
		return empService.getEmpRemoveCount(empNo);
	}
	
	//@PatchMapping : 데이터 update
	@PatchMapping("/emp")
	public int callEmpUpdate(@RequestBody EmpVO empVO) {
		return empService.getEmpUpdateCount(empVO);
	}
	
	@PostMapping("/dept")
	public int callDeptInsert(@RequestBody DeptVO deptVO) {
		return empService.getDeptPostCount(deptVO);
	}
	
	@DeleteMapping("/dept/deptno/{deptno}")
	public int callDeleteDeptno(@PathVariable("deptno") int deptno) {
		return empService.getDeptDeleteCount(deptno);
	}
	

	
}
