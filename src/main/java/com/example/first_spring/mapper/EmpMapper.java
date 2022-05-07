package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.first_spring.vo.CommVO;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.EnameVO;
import com.example.first_spring.vo.HiredateVO;

@Mapper
public interface EmpMapper {
	
	/**
	 * @return
	 * comment : emp테이블 전체사원 조회
	 */
	public List<EmpVO> getEmpList(); 

	public EmpVO getEmp(int empNo);
	
	// MyBatis(SQL)에 데이터를 2개 이상 넘길 때는 @Param이용!
	public List<EmpVO> selectEmpWhereJobAndSal(@Param("jobName") String jobName, @Param("sal") int sal);
	//xml파일의 쿼리에서 where절에 나오는 조건의 #{} 중괄호 안에 Param의 변수 이름과 동일 해야한다.
	
	//문제 1. 이름에 L문자가 두 번 이상 포함된 사원 이름, 직업 조회(* L을 두번만 포함하는 사람)
	public List<EnameVO> getEmpEname();
	
	//문제 2. 커미션(comm)이 null('')인 사원의 이름, 커미션 조회
	public List<CommVO> getEmpComm();
	
	//문제 3. 입사일이 '1980-12-17' ~ '1982-01-23'인 사원의 이름, 입사날짜 조회
	public List<HiredateVO> getEmpHiredate();
	
//	public List<EmpVO> getJobSal(String jobName, int sal);
	
	
	
	
//	<!-- 문제 0. 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회 -->
	public List<EmpVO> getEmpDeptNo(int sal);
	
//	<!-- 문제 1. MGR이 NULL인 사원 이름, 직업, 급여 조회 -->
	public List<EmpVO> getMgr();
	
//	<!-- 문제 2. 특정 년도에 입사한 사원 이름, 직업, 입사날짜, 급여 조회-->
	public List<EmpVO> getHiredateYear(String year);
	
//	<!-- 문제 3. 입사 날짜가12월에 입사한 사원 이름, 급여 조회-->
	public List<EmpVO> getHiredateMonth(String month);
	
//	<!-- 문제 4. 특정 job에 속한 사원번호, 사원 이름, 입사날짜 조회 -->
	public List<EmpVO> getJob(String jobName);
	
	
	
	
	
	
	
	
	
	
	//Mapper 클래스는 Interface파일로 생성!
}
