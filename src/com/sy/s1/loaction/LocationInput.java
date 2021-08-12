package com.sy.s1.loaction;

import java.util.Scanner;

public class LocationInput {
	
	public LocationDTO inputId() {	
		
		LocationDTO dto = new LocationDTO();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Location_id를 입력해주세요~!~!");
		int id = sc.nextInt();
		
		dto.setLocation_id(id);
				
		return dto;
		
	}
}
