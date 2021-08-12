package com.sy.s1;

import java.sql.Connection;
import java.sql.SQLException;

import com.sy.s1.employee.EmployeeController;
import com.sy.s1.loaction.LocationController;
import com.sy.s1.loaction.LocationDAO;
import com.sy.s1.util.DBConnect;
import java.sql.SQLException;

import com.sy.s1.departments.Depart_EmpDTO;
import com.sy.s1.departments.DepartmentsDAO;
import com.sy.s1.departments.DepartmentsDTO;
import com.sy.s1.employee.EmployeeController;
import com.sy.s1.loaction.LocationController;
import com.sy.s1.loaction.LocationDAO;
import com.sy.s1.util.DBConnect;



public class Study9Main {

	public static void main(String[] args) {
	
//		LocationController lc = new LocationController();
//		lc.start();
//		LocationDAO dao = new LocationDAO();
//		dao.getCount();
		
//		EmployeeController controller = new EmployeeController();
//		controller.start();
		
		DepartmentsDAO dao = new DepartmentsDAO();
		DepartmentsDTO departmentsDTO = new DepartmentsDTO();
		
		departmentsDTO.setDepartment_id(90);
		Depart_EmpDTO dto = dao.getJoin(departmentsDTO);
		
		System.out.println(dto.getDepartment_name());
		for(int i =0; i<dto.getAr().size(); i++) {
			
			System.out.println("-----------------");
			
			System.out.println(dto.getAr().get(i).getLast_name());
			System.out.println(dto.getAr().get(i).getSalary());
			System.out.println(dto.getAr().get(i).getHire_date());
			
			System.out.println("-----------------");
			
		}
		
	}

}
