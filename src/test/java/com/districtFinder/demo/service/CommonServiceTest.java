package com.districtFinder.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.districtFinder.demo.dao.CommonDAO;
import com.districtFinder.demo.dto.DistrictDTO;




//to enable mockito inside this test we use have to extend our class with mockito class use below annotation

@ExtendWith(MockitoExtension.class)
public class CommonServiceTest {
	
	@Mock
	private CommonDAO commonDao;
	
	//we use mock annotation to create instance
	@InjectMocks
	private CommonServiceImpl commonService ;
	
	//creating new object by using new in test is not feasible
	//therefore we create mock object 

	//just first test case by using test annoation in the class
	@Test
	public void firstTestCase() {
		System.out.println("You are doing awesome");
	}
	
	//give some meaningful name to the method 
	//we will not create the same method in the unit test method
	//we will call that method here by using the service instance (:))
	//for service instance we will use mock annoation and make this class mockito enabled by using 
	//the below test will not insert any data :) so it will return null
	@Test
	public void savingDistrictInDB() {
		System.out.println("Begining of savingDistrictInDB");
		DistrictDTO districtDto = new DistrictDTO();
//		commonService.saveDistrict(districtDto);
		//now checking whether the return save district is same to the passed district
		List<DistrictDTO> temp = new ArrayList<>();
//		Mockito.when(commonService.getAllDistrictService()).thenReturn(temp);
		
		//assert means when we want to assert something means we have to test something
		Assertions.assertEquals(2, 2);
		Assertions.assertTrue(temp.isEmpty());
		Assertions.assertNotNull(temp);
	}
	
	///*Lifecycle of unit test 
	//first we use BeforeAll annotation . this test method will be executed first in the class
	//BeforeAll will be executed exactly once and this is class level . so it will be executed in the test case where only one test case is executed
	//use case 1.if we are using testing data base we can do the configuration here
	//For Class Level Setup
	@BeforeAll
	public static void beforeAllExample() {
		System.out.println("Example of Before all called at the first");
	}
	
	//it will be executed before each test case :) as per name say
	//use case if we have some object that is changing at each test case then we use this.
	@BeforeEach
	public void beforeEachExample() {
		System.out.println("Example of BeforeEach");
	}
	
	///after this @test will be executed
	
	//to clean up all the resources we use After Each and After All Annotation
	
	//After Each will be executed after each test method
	//After all will be executed at the end of the test.
	//resetting some of the local variable
	@AfterEach
	public void afterEachExample() {
		System.out.println("After Each Example");
		
	}
	
	//cleaning up the class level data
	//destroying the connection to the db
	@AfterAll
	public static void afterAllExample() {
		System.out.println("After All Example");
	}
	
	//testing method which do not return any values
	@Test
	public void deleteByIdExampleWillBeBest() {
		DistrictDTO districtDto = new DistrictDTO();
		Mockito.doNothing().when(commonService).saveDistrict(districtDto);
		
		commonService.saveDistrict(districtDto);
		Mockito.verify(commonService,Mockito.times(1)).saveDistrict(districtDto);
		
	}

}
