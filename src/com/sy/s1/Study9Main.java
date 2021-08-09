package com.sy.s1;

import java.sql.Connection;
import java.sql.SQLException;

import com.sy.s1.loaction.LocationDAO;
import com.sy.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
		LocationDAO dao = new LocationDAO();
		
		dao.getlist();

	}

}
