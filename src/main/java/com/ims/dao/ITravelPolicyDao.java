package com.ims.dao;

import java.util.List;

import com.ims.model.TravelPolicy;

public interface ITravelPolicyDao {

	public Integer saveTravelPolicy(TravelPolicy travelPolicy);

	public void deleteTravelPolicy(Integer id);

	public void updateTravelPolicy(TravelPolicy travelPolicy);

	public TravelPolicy getOneTravelPolicy(Integer id);

	public List<TravelPolicy> getAllTravelPolicies();
}
