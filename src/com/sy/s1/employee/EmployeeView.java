package com.sy.s1.employee;

import java.util.ArrayList;

import com.sy.s1.loaction.LocationDTO;

public class EmployeeView {
	
	public void view(int avg) {
		System.out.println("급여 평균 : " + avg);
	}
	
	public void view(ArrayList<EmployeeDTO> ar) {
		for(int i=0; i<ar.size(); i++) {
			this.view(ar.get(i));			
		}
	}
		
	public void view(EmployeeDTO dto) {			
		System.out.println(dto.getEmployee_id());
		System.out.println(dto.getFirst_name());
		System.out.println(dto.getLast_name());
		System.out.println(dto.getEmail());
		System.out.println(dto.getPhone_number());
		System.out.println(dto.getHire_date());
		System.out.println(dto.getJob_id());
		System.out.println(dto.getSalary());
		System.out.println(dto.getCommission_pct());
		System.out.println(dto.getManager_id());
		System.out.println(dto.getDepartment_id());
		System.out.println("---------------------------------");
	}
	
	public void view(Emp_DepartDTO emp_DepartDTO) {
		System.out.println("이름 : " + emp_DepartDTO.getLast_name());
		System.out.println("월급 : " + emp_DepartDTO.getSalary());
		System.out.println("입사 날짜 : " + emp_DepartDTO.getHire_date());
		System.out.println("부서 이름 : " + emp_DepartDTO.getDepartmentsDTO().getDepartment_name());
	}
}
