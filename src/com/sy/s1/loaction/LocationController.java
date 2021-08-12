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
			System.out.println("3. 끝내기");
			
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
			}else {
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
