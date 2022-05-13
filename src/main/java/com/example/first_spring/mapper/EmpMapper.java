package com.example.first_spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.first_spring.vo.CommVO;
import com.example.first_spring.vo.DeptVO;
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
	
	
	//문제. job이 manager이고 sal이 2500이상받는 사원comm을 500으로 업데이트 후
		// 사원이름,직업,커미션 조회
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
	
	
	
//	1. emp에서 없는 부서번호를 찾아서 해당 부서 번호로 insert 하기.
	// return타입이 EmpVO를 한 이유는 쿼리의 결과값이 단일행(1개)이기 때문이다.
	// 2개이상(다중행)일 경우에는 리턴타입 List<>로!
	public EmpVO selectDeptNo();//사원이 없는 deptno 조회
//	2. 급여 3000이상인 사람 데이터 삭제
	public List<EmpVO> getEmpNoList();// 급여 3000이상인 사람 조회
	
	// return타입이 왜 int인지? insert, delete, update는 
	public int insertEmp(EmpVO empVO);//emp 데이터 삽입
	 
	public int deleteEmp(int empNo);//emp 데이터 삭제
	
	public int updateEmp(EmpVO empVO); //emp 데이터 수정
	
	public int insertDept(DeptVO deptVO);// dept 데이터 삽입
	 
	public int deleteDeptno(int deptNo); //dept 데이터 삭제
	
	
	public List<EmpVO> selectEmpEname(String search);
	
	
	public List<EmpVO> selectEmpMgr(@Param("isMgr") String isMgr);
	//MyBatis에는 boolean형이 없기 때문에 파라미터로 String으로 받는다.
	
	public int updateEmpno(@Param("empno") int empno);
	
	public int updateEmpJobSal(EmpVO vo);
	
	public EmpVO selectEmpCommSal(@Param("empno") int empno);
	
	public int updateEmpSal(EmpVO vo);
	
	public List<Map<String, Object>> selectEmpMapList();
	//Map<String, Object> Map안에 Object를 넣어준 이유는 key(MyBatis쿼리의 컬럼명)의 value값의 타입이 어떻게 올지 몰라서
	// 타입을 모두 포함하는 부모인Object를 사용~!
	//Mapper 클래스는 Interface파일로 생성!
}
