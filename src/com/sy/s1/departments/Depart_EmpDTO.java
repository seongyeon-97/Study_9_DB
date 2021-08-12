package com.sy.s1.departments;

import java.util.ArrayList;

import com.sy.s1.employee.EmployeeDTO;

public class Depart_EmpDTO extends DepartmentsDTO{
	
	private ArrayList<EmployeeDTO> ar;

	public ArrayList<EmployeeDTO> getAr() {
		return ar;
	}

	public void setAr(ArrayList<EmployeeDTO> ar) {
		this.ar = ar;
	}
	
	
}
