package com.sy.s1.employee;

import com.sy.s1.departments.DepartmentsDAO;
import com.sy.s1.departments.DepartmentsDTO;

public class Emp_DepartDTO extends EmployeeDTO{
	
	private DepartmentsDTO departmentsDTO;

	public DepartmentsDTO getDepartmentsDTO() {
		return departmentsDTO;
	}

	public void setDepartmentsDTO(DepartmentsDTO departmentsDTO) {
		this.departmentsDTO = departmentsDTO;
	}
	
	
	
}
