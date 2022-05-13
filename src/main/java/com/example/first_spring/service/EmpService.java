package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.CommVO;
import com.example.first_spring.vo.DeptVO;
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
	
	
	@Transactional(rollbackFor = {Exception.class})
	public List<EmpVO> selectEmpWhereJobAndSal(String jobName, int sal){
		
		if(jobName.equals("SALESMAN")) {
			return null;
		}
		
		//문제. job이 manager이고 sal이 2500이상받는 사원comm을 500으로 업데이트 후
		// 사원이름,직업,커미션 조회
		List<EmpVO> list = empMapper.selectEmpWhereJobAndSal(jobName, sal);
		int comm = 300; //커미션
		int rows = 0;
		System.out.println(list);
		// 현재 list에는 sql쿼리의 결과가 담겨져 있다.
		for(int i=0; i<list.size(); i++) {
			list.get(i).setComm(comm);
			int empno = list.get(i).getEmpno();
			System.out.println("empno ====> "+empno);
			EmpVO vo = list.get(i);
			System.out.println(vo);
			rows += empMapper.updateEmp(vo);
		}
		
		if(rows > 0) {
			return list;
			// 쿼리 결과의 행의 개수(rows)가 0보다 크면
		}
		
		return null;
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
	@Transactional(rollbackFor = {Exception.class})
	public List<EmpVO> getHiredateMonth(String month){
		int max = 0;
		List<EmpVO> list = empMapper.getHiredateMonth(month);
		EmpVO vo = null;
		System.out.println(list);
		for(int i=0; i<list.size(); i++) {
			if(max<list.get(i).getSal()){
				max = list.get(i).getSal();
				if(max == list.get(i).getSal()) {
					vo = list.get(i);
				}
			}
		}
		List<EmpVO> maxSalEmpnoList = new ArrayList<EmpVO>();
		maxSalEmpnoList.add(vo);
		System.out.println(maxSalEmpnoList);
		return maxSalEmpnoList;
	}
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	public List<EmpVO> getJob(String jobName){
		return empMapper.getJob(jobName);
	}
	// 문제. emp에서 없는 부서번호를 찾아서 해당 부서 번호로 insert 하기.
	@Transactional(rollbackFor = {Exception.class})
	public int setEmp(EmpVO vo) {
//		EmpVO empVO = empMapper.selectDeptNo();
//		int deptNo = empVO.getDeptno();
//		
//		vo.setDeptno(deptNo);
		int rows = empMapper.insertEmp(vo); //몇행 insert 되었는지 리턴
		return rows;
	}
	
	// 급여3000이상인 사람 삭제 Service
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpRemoveCount(int empNo) {
//		List<EmpVO> voList = empMapper.getEmpNoList();
//		for(int i=0; i<voList.size(); i++) {
//			if(empNo == voList.get(i).getEmpno()) {
				int rows = empMapper.deleteEmp(empNo);
				return rows;
//			}
//		}
//		return 0;
	}
	
	
	@Transactional(rollbackFor = {Exception.class})
	// @Transactional(rollbackFor = {Exception.class}) : 로직에서 에러가 나면 Exception이 에러를 잡고 이전 commit으로 rollback 하겠다는 어노테이션(@Transactional)
	public int getEmpUpdateCount(EmpVO vo) {
		int rows = empMapper.updateEmp(vo); //몇행 update 되었는지 리턴
//		UserVO user = null;
//		String name = user.getName();
//		System.out.println(name);
		// UserVO클래스를 new로 호출하지 않아서 서버에서는 에러가 뜨지만 데이터베이스에는 update가 그대로 진행한다.
		// 그래서 에러 or null이 올 경우 업데이트가 되지 않게 
		// 서버에서 오류나는 것들을 @Transactional이 잡아주고 update되기 전 commit으로 rollback 시켜줌.
		
		return rows;
	}
	@Transactional(rollbackFor = {Exception.class})
	public int getDeptPostCount(DeptVO deptVO) {
		int rows = empMapper.insertDept(deptVO);
		return rows;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int getDeptDeleteCount(int deptNo) {
		int rows = empMapper.deleteDeptno(deptNo);
		return rows;
	}
	
	
	//문제. A로 시작하는 사람 수 구하기
	@Transactional(rollbackFor = {Exception.class})
	public int selectEmpEname(String ename) {
		List<EmpVO> list = empMapper.selectEmpEname(ename);
		return list.size();
	}
	
	
	@Transactional(rollbackFor = {Exception.class})
	public List<EmpVO> getEmpIsMgrList(String isMgr){
		return empMapper.selectEmpMgr(isMgr);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int getUpdateEmpno(int empno) {
		int rows = empMapper.updateEmpno(empno);
		return rows;
	}
	
	
//	문제. 사원번호가 7844번인 사원의 COMM이 0이거나 NULL이면 기존 급여에서 500을 추가 COMM이 있다면 0 리턴!
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpUpdateSalCount(int empno) {
		
		//COMM이 0이거나 NULL이면
		EmpVO vo = empMapper.selectEmpCommSal(empno);
		System.out.println();
		if(vo != null) {
			int comm = vo.getComm();
			
			if(comm == 0) {
				int bonus = 500;
				int sal = vo.getSal();
				vo.setSal(sal+bonus);
				int getSal = vo.getSal();
				//update 로직 추가
				return empMapper.updateEmpSal(vo);
			}
		}
		return 0;
	}
	
	
	public List<Map<String, Object>> getEmpMapList(){
		
		return empMapper.selectEmpMapList();
	}
	
	public int getApi(int empno, EmpVO empVO) {
		empVO.setEmpno(empno);
		return empMapper.updateEmpJobSal(empVO);
	}
	
}
