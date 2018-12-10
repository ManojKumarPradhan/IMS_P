package com.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.ITravelPolicyDao;
import com.ims.model.TravelPolicy;
import com.ims.service.ITravelPolicyService;

@Service
public class TravelPolicyServiceImpl implements ITravelPolicyService {

	@Autowired
	private ITravelPolicyDao dao;

	@Transactional
	public Integer saveTravelPolicy(TravelPolicy travelPolicy) {
		return dao.saveTravelPolicy(travelPolicy);
	}

	@Transactional
	public void deleteTravelPolicy(Integer id) {
		dao.deleteTravelPolicy(id);
	}

	@Transactional
	public void updateTravelPolicy(TravelPolicy travelPolicy) {
		dao.updateTravelPolicy(travelPolicy);
	}

	@Transactional(readOnly = true)
	public TravelPolicy getOneTravelPolicy(Integer id) {
		return dao.getOneTravelPolicy(id);
	}

	@Transactional(readOnly = true)
	public List<TravelPolicy> getAllTravelPolicies() {
		return dao.getAllTravelPolicies();
	}

}
