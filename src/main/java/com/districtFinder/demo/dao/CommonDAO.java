package com.districtFinder.demo.dao;

import java.util.List;

import com.districtFinder.demo.entities.District;


public interface CommonDAO {

	public void saveDistrict(District district);
	public List<District> getDistrictDAO() ;
}
