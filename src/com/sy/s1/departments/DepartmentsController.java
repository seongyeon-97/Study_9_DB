package com.sy.s1.departments;

public class DepartmentsController {
	private DepartmentsDAO departmentsDAO;
	private DepartmentsView departmentsView;
	
	public DepartmentsController() {
		departmentsDAO = new DepartmentsDAO();
		departmentsView = new DepartmentsView();
	}
	
	public void start() {
		
	}
	
}
