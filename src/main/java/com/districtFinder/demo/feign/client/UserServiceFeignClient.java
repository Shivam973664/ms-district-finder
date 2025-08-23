package com.districtFinder.demo.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("fastCurve")
public interface UserServiceFeignClient {
	
	@GetMapping("/api/getPaymentOptionOfUser")
	public ResponseEntity<List<String>> getPaymentOption();
}
