package com.sy.s1.loaction;

import java.util.ArrayList;

public class LocationView {
	
	public void view(int count) {
		System.out.println("COUNT :" + count);
	}
	
	public void view(ArrayList<LocationDTO> ar) {
		for(int i=0; i<ar.size(); i++) {
			
//			System.out.println(ar.get(i).getLocation_id());
//			System.out.println(ar.get(i).getStreet_address());
//			System.out.println(ar.get(i).getPostal_code());
//			System.out.println(ar.get(i).getCity());
//			System.out.println(ar.get(i).getState_province());
//			System.out.println(ar.get(i).getCountry_id());
			
			this.view(ar.get(i));
			System.out.println("---------------------------------------------------------");
		}
	}
	
	public void view(LocationDTO locationDTO) {
		
		System.out.println(locationDTO.getLocation_id());
		System.out.println(locationDTO.getStreet_address());
		System.out.println(locationDTO.getPostal_code());
		System.out.println(locationDTO.getCity());
		System.out.println(locationDTO.getState_province());
		System.out.println(locationDTO.getCountry_id());
		
	}
	
}
