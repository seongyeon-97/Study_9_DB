package com.sy.s1.loaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sy.s1.util.DBConnect;

public class LocationDAO {
		
	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	public int getCount() {
		Connection con =null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT COUNT(LOCATION_ID) FROM LOCATIONS"; 
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			rs.next();
			count = rs.getInt(1);
			
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
		return count;
	}
	
	
	public ArrayList<LocationDTO> getSearch() {
	      Connection con = null;
	      PreparedStatement st = null;
	      ResultSet rs = null;
	      ArrayList<LocationDTO> ar = new ArrayList<>();
	      Scanner sc = new Scanner(System.in);
	      try {

	         con = dbConnect.getConnect();

	         System.out.println("검색 할 글자를 입력하세요.");
	         String input = sc.next().toLowerCase();
	         String sql = "SELECT * FROM LOCATIONS WHERE lower(STREET_ADDRESS) LIKE ?";

	         st = con.prepareStatement(sql);

	         st.setString(1, "%" + input + "%");

	         rs = st.executeQuery();

	         while (rs.next()) {
	            LocationDTO locationDTO = new LocationDTO();

	            locationDTO.setLocation_id(rs.getInt("location_id"));
	            locationDTO.setStreet_address(rs.getString("street_address"));
	            locationDTO.setPostal_code(rs.getString("postal_code"));
	            locationDTO.setCity(rs.getString("city"));
	            locationDTO.setState_province(rs.getString("state_province"));
	            locationDTO.setCountry_id(rs.getString("country_id"));

	            ar.add(locationDTO);

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
	
	
	public LocationDTO getOne(int location_id) {
		
		//ADD-DTO Branch
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, location_id);
			
			rs = st.executeQuery();					
			
			if(rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return locationDTO;
		
	}
	
	
	
	public ArrayList<LocationDTO> getlist() {
		
		//loactions 테이블 조회 후 출력
				
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			System.out.println("드라이버 접속 성공");
			System.out.println(con);
						
			String sql = "SELECT * FROM LOCATIONS";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				LocationDTO locationDTO =new LocationDTO();			
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
				ar.add(locationDTO);
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
		return ar;
		
	}
	
	
}
