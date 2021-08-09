package com.sy.s1.loaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sy.s1.util.DBConnect;

public class LocationDAO {
		
	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	public void getOne(int location_id) {
		
		//ADD-DTO Branch
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, location_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				
				System.out.print(rs.getInt("LOCATION_ID") + "\t");
				System.out.print(rs.getString("STREET_ADDRESS") + "\t");
				System.out.print(rs.getString("POSTAL_CODE") + "\t");
				System.out.print(rs.getString("CITY") + "\t");
				System.out.print(rs.getString("STATE_PROVINCE") + "\t");
				System.out.println(rs.getString("COUNTRY_ID") + "\t");
				
			}else {
				
				System.out.println("아이디가 존재하지 않습니다.");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public void getlist() {
		
		//loactions 테이블 조회 후 출력
		
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String  driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnect();
			System.out.println("드라이버 접속 성공");
			System.out.println(con);
						
			String sql = "SELECT * FROM LOCATIONS";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("LOCATION_ID") + "\t");
				System.out.print(rs.getString("STREET_ADDRESS") + "\t");
				System.out.print(rs.getString("POSTAL_CODE") + "\t");
				System.out.print(rs.getString("CITY") + "\t");
				System.out.print(rs.getString("STATE_PROVINCE") + "\t");
				System.out.println(rs.getString("COUNTRY_ID") + "\t");
				System.out.println("------------------------------------------------------");
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
}
