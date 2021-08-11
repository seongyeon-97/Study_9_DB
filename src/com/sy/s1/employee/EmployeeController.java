package com.sy.s1.employee;

import java.util.ArrayList;

public class EmployeeController {
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
	}
	
	public void start() {
		//전체 사원 출력
//		ArrayList<EmployeeDTO> ar = employeeDAO.getList();
//		employeeView.view(ar);
		
		//사원번호 입력받아 출력
//		EmployeeDTO dto = employeeDAO.getId(200);
//		employeeView.view(dto);
		
		//last_name 입력받아 출력
//		EmployeeDTO dto = employeeDAO.getSearchLast_name();
//		employeeView.view(dto);
		
		//FIRST_NAME 입력받아 출력
//		EmployeeDTO dto = employeeDAO.getSearchFirst_name();
//		employeeView.view(dto);
		
		//전체평균급여정보
//		int avg = employeeDAO.getSalaryAvg();
//		employeeView.view(avg);
		
		//부서별평균급여정보
//		ArrayList<EmployeeDTO> ar= employeeDAO.getSalaryAvgGroupby();
//		employeeView.groupView(ar);
		
		Emp_DepartDTO emp_DepartDTO = employeeDAO.getJoin();
		employeeView.view(emp_DepartDTO);
		
	}
	
}
