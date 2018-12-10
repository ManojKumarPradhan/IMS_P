package com.ims.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ims.dao.ITravelPolicyDao;
import com.ims.model.TravelPolicy;

@Repository
public class TravelPolicyDaoImpl implements ITravelPolicyDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveTravelPolicy(TravelPolicy travelPolicy) {
		return (Integer) hibernateTemplate.save(travelPolicy);
	}

	@Override
	public void deleteTravelPolicy(Integer id) {
		hibernateTemplate.delete(new TravelPolicy(id));
	}

	@Override
	public void updateTravelPolicy(TravelPolicy travelPolicy) {
		hibernateTemplate.update(travelPolicy);
	}

	@Override
	public TravelPolicy getOneTravelPolicy(Integer id) {
		return hibernateTemplate.get(TravelPolicy.class, id);
	}

	@Override
	public List<TravelPolicy> getAllTravelPolicies() {
		return hibernateTemplate.loadAll(TravelPolicy.class);
	}

}
