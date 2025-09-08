package com.districtFinder.demo.service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.districtFinder.demo.dao.CommonDAO;
import com.districtFinder.demo.dto.DistrictDTO;
import com.districtFinder.demo.entities.District;
import com.districtFinder.demo.feign.client.PaymentMicroServiceFeignClient;
import com.districtFinder.demo.feign.client.UserServiceFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDAO commonDao;

	@Autowired
	PaymentMicroServiceFeignClient paymentMicroserviceFeignClient;
	
	@Autowired
	UserServiceFeignClient userServiceFeignClient;
	
	private final ExecutorService executorService = Executors.newFixedThreadPool(1);

	public void saveDistrict(DistrictDTO districtDto) {
		District district = new District(districtDto.getDistrictName(), districtDto.getCity(), districtDto.getState());
		districtDto.setId(district.getId());
		this.commonDao.saveDistrict(district);
	}

	public List<DistrictDTO> getAllDistrictService() {
		List<District> list = commonDao.getDistrictDAO();
		List<DistrictDTO> rest = list.stream().map(a -> new DistrictDTO(a.getDistrictName(), a.getCity(), a.getState()))
				.collect(Collectors.toList());
		return rest;
	}

	public List<String> getPaymentOption() {
		String url = "http://localhost:8080/payment-service/paymentoption";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, null, List.class);
		return response.getBody();
	}

	@CircuitBreaker(fallbackMethod = "getPaymentOPtionByFCUsingUserService",name="justtrying")
	public ResponseEntity<List<String>> getPaymentOPtionByFC() {
		
		///second way by using java start
		Callable<ResponseEntity<List<String>>> callable = ()-> paymentMicroserviceFeignClient.getPaymentOptionByFeignClientWay();
		Future<ResponseEntity<List<String>>> future = executorService.submit(callable);
		try {
			return future.get(2, TimeUnit.SECONDS);
		}catch(Exception e) {

			if (1==1) {return this.getPaymentOPtionByFCUsingUserService(new Throwable("yo"));};
		}
		///second way by using java end
		
		System.out.println("making call vaia feign client");
		return paymentMicroserviceFeignClient.getPaymentOptionByFeignClientWay();
	}

	public ResponseEntity<List<String>> getPaymentOPtionByFCUsingUserService(Throwable t) {

		System.out.println("making call vaia feign client : Fallback to UserService");
		return userServiceFeignClient.getPaymentOption();
	}
	
	
	private boolean forTestingPrivateMethods(String justAParameter) {
		System.out.println("THis is private method we need to test it using SPring boot test");
		
		if(justAParameter.equals("book")) {
			return true;
		}
		else {
			throw new RuntimeException();
		}
	}
	

}
