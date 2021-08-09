package com.sy.s1.loaction;

import java.util.ArrayList;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		
		locationView = new LocationView();
	}
	
	
	
	public void start() {
		
		//db에서 location table의 모든 정보 조회
		//ArrayList<LocationDTO> ar = locationDAO.getSearch();
		//locationView.view(ar);
		
		int count = locationDAO.getCount();
		locationView.view(count);
		//locationView.view();
		
		//LocationDTO locationDTO = locationDAO.getOne(1000);
		//locationView.view(locationDTO);
		
	}
	
}
