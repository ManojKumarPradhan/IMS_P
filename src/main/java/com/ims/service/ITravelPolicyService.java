package com.ims.service;

import java.util.List;

import com.ims.model.TravelPolicy;

public interface ITravelPolicyService {

	public Integer saveTravelPolicy(TravelPolicy travelPolicy);

	public void deleteTravelPolicy(Integer id);

	public void updateTravelPolicy(TravelPolicy travelPolicy);

	public TravelPolicy getOneTravelPolicy(Integer id);

	public List<TravelPolicy> getAllTravelPolicies();
}
