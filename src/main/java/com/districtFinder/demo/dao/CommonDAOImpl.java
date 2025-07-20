package com.districtFinder.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.districtFinder.demo.entities.District;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CommonDAOImpl implements CommonDAO {


	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveDistrict(District district) {
		entityManager.persist(district);
	}
	
	@SuppressWarnings("unchecked")
	public List<District> getDistrictDAO() {
		Query q1 = entityManager.createNativeQuery("select * from district", District.class);
//		q1.
		List<District> list =q1.getResultList();
		
		return list;
	}

}
