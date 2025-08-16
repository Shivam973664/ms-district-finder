package com.districtFinder.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.districtFinder.demo.dto.DistrictDTO;
import com.districtFinder.demo.service.CommonService;

@RestController
@RequestMapping(value="/district")
public class DistrictController {

	@Autowired
	private CommonService commonService;
	
	@PostMapping
	public ResponseEntity<DistrictDTO> postingDistrict(@RequestBody DistrictDTO districtDto){
		commonService.saveDistrict(districtDto);
		
		return ResponseEntity.ok(districtDto);
	}
	
	@GetMapping(value="")
	public ResponseEntity<List<DistrictDTO>> getAllDistrict(){
		List<DistrictDTO> list = commonService.getAllDistrictService();
		return ResponseEntity.ok(list);
	}
	
	//conumer here is District Service so thats why code change take place here
//	http://localhost:8080/districtfinder/payment/option
	//Sir have return Only List<String> not Resp....
	@GetMapping(value="/payment/option")
	public ResponseEntity<List<String>> getPaymentOption(){
		List<String> result = commonService.getPaymentOption();
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value="/payment/option/v2")
	public ResponseEntity<List<String>> getPaymentOptionByFeignClientWay(){
		return commonService.getPaymentOPtionByFC();
	}
	
	

}
