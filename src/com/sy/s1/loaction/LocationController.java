package com.sy.s1.loaction;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
	}
	
	
	
	public void start() {
		
		//db에서 location table의 모든 정보 조회
		//locationDAO.getlist();
		//locationView.view();
		
		locationDAO.getOne(0);
		locationView.view();
		
	}
	
}
