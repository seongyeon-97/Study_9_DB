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
		ArrayList<EmployeeDTO> ar = employeeDAO.getList();
		employeeView.view(ar);
	}
	
}
