package com.sy.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;

import com.sy.s1.departments.DepartmentsDTO;
import com.sy.s1.loaction.LocationDTO;
import com.sy.s1.util.DBConnect;

public class EmployeeDAO {
	//DB와 연결
	private DBConnect dbConnect;
	
	public EmployeeDAO() {
		dbConnect = new DBConnect();
	}
	
	public Emp_DepartDTO getJoin() {
		Connection con =null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Emp_DepartDTO emp_DepartDTO = null;
		DepartmentsDTO departmentsDTO = null;
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME FROM EMPLOYEES E INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID WHERE E.EMPLOYEE_ID = 101";

			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				emp_DepartDTO = new Emp_DepartDTO();
				departmentsDTO = new DepartmentsDTO(); 
				emp_DepartDTO.setLast_name(rs.getString("last_name"));
				emp_DepartDTO.setSalary(rs.getInt("salary"));
				emp_DepartDTO.setHire_date(rs.getDate("hire_date"));
				departmentsDTO.setDepartment_name(rs.getString("department_name"));
				emp_DepartDTO.setDepartmentsDTO(departmentsDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp_DepartDTO;
	}
	
	
	public ArrayList<EmployeeDTO> getList() {
		Connection con =null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommission_pct(rs.getDouble("commission_pct"));
				dto.setManager_id(rs.getInt("manager_id"));
				dto.setDepartment_id(rs.getInt("department_id"));				
				ar.add(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;
	}
	
	public EmployeeDTO getId(int employee_id) {
		Connection con =null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO dto = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, employee_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommission_pct(rs.getDouble("commission_pct"));
				dto.setManager_id(rs.getInt("manager_id"));
				dto.setDepartment_id(rs.getInt("department_id"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}
	public EmployeeDTO getSearchLast_name() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		EmployeeDTO dto = null;
		try {
			con = dbConnect.getConnect();
			System.out.println("last_name을 입력하시오");
			String name = sc.next();
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME = ?";
			st = con.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			
			if(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommission_pct(rs.getDouble("commission_pct"));
				dto.setManager_id(rs.getInt("manager_id"));
				dto.setDepartment_id(rs.getInt("department_id"));
				
			}else {
				System.out.println("다시입력해주세요");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;		
		
	}
	
public EmployeeDTO getSearchFirst_name() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		EmployeeDTO dto = null;
		try {
			con = dbConnect.getConnect();
			System.out.println("first_name을 입력하시오");
			String name = sc.next();
			String sql = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME = ?";
			st = con.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			
			if(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setSalary(rs.getInt("salary"));
				dto.setCommission_pct(rs.getDouble("commission_pct"));
				dto.setManager_id(rs.getInt("manager_id"));
				dto.setDepartment_id(rs.getInt("department_id"));
				
			}else {
				System.out.println("다시입력해주세요");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;		
		
	}

	public int getSalaryAvg() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO dto = null;
		int avg = 0;
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			avg = rs.getInt(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return avg;
	}
	
	public ArrayList<EmployeeDTO> getSalaryAvgGroupby() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		int avg = 0;
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT DEPARTMENT_ID, AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			avg = rs.getInt(1);
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();				
				ar.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;
	}
}
