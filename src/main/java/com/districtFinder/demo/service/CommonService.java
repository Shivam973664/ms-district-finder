package com.districtFinder.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.districtFinder.demo.dto.DistrictDTO;


public interface CommonService {
	
	public void saveDistrict(DistrictDTO districtDto);
	
	public List<DistrictDTO> getAllDistrictService();
	
	public List<String> getPaymentOption();
	
	public ResponseEntity<List<String>> getPaymentOPtionByFC();

}
