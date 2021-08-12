package com.sy.s1.loaction;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;

	public LocationController() {
		locationDAO = new LocationDAO();
		locationInput = new LocationInput();
		locationView = new LocationView();
	}
	
	
	
	public void start() {
		
		//db에서 location table의 모든 정보 조회
		//ArrayList<LocationDTO> ar = locationDAO.getSearch();
		//locationView.view(ar);
		
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		
		while(check) {
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 하나의 정보 출력");
			System.out.println("3. 지역 정보 출력");
			System.out.println("4. 지역 정보 삭제");			
			System.out.println("5. 끝내기");
			
			int select = sc.nextInt();
			
			if(select==1) {
				ArrayList<LocationDTO> ar = locationDAO.getlist();
				if(ar.size()>0) {
					locationView.view(ar);
				}else {
					locationView.view("data가 없습니다.");
				}
			}else if(select==2) {
				LocationDTO locationDTO = locationInput.inputId();
				locationDTO = locationDAO.getOne(locationDTO);
				if(locationDTO!=null) {
					locationView.view(locationDTO);
				}else {
					locationView.view("없는 id입니다.");
				}
			}else if(select==3) {
				LocationDAO dao = new LocationDAO();
				LocationDTO dto = new LocationDTO();
				System.out.println("Location_id를 입력하시오");
				int location_id = sc.nextInt();
				dto.setLocation_id(location_id);
				System.out.println("Street_address를 입력하시오");
				String street_address = sc.next();
				dto.setStreet_address(street_address);
				System.out.println("Postal_code를 입력하시오");
				String postal_code = sc.next();
				dto.setPostal_code(postal_code);
				System.out.println("City를 입력하시오");
				String city = sc.next();
				dto.setCity(city);
				System.out.println("State_province를 입력하시오");
				String state_province = sc.next();
				dto.setState_province(state_province);
				System.out.println("Country_id를 입력하시오");
				String country_id = sc.next();
				dto.setCountry_id(country_id);
				
				int result = dao.setInsert(dto);
				
				if(result>0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
			}else if(select==4) {
				System.out.println("삭제할 데이터의 Location_id를 입력하시오");
				int location_id = sc.nextInt();
				LocationDTO dto = new LocationDTO();
				dto.setLocation_id(location_id);
				int result = locationDAO.delete(dto);
				if(result>0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
			}
			else {
				check = false;
				break;
			}
		}
		
//		int count = locationDAO.getCount();
//		locationView.view(count);
		//locationView.view();
		
		//LocationDTO locationDTO = locationDAO.getOne(1000);
		//locationView.view(locationDTO);
		
//		LocationDTO locationDTO = locationDAO.getLocation(100);
//		locationView.view(locationDTO);
		
	}
	
}
