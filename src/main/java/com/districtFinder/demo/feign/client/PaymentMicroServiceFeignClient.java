package com.districtFinder.demo.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Request.HttpMethod;

//for making this interface as feign Interface add annotation 
//and provide the MS id of the producer services
@FeignClient("payment-service")
public interface PaymentMicroServiceFeignClient {

//	@GetMapping("/payment/option") //both will work
	@RequestMapping(method = RequestMethod.GET,path = "/paymentoption")
	ResponseEntity<List<String>> getPaymentOptionByFeignClientWay();
	
	
//	@GetMapping(value="/paymentoption")
//	public ResponseEntity<List<String>> getPaymentOption();
}
