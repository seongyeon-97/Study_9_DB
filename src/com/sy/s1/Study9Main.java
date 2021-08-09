package com.sy.s1;

import java.sql.Connection;
import java.sql.SQLException;

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
		
		EmployeeController controller = new EmployeeController();
		controller.start();
		
	}

}
