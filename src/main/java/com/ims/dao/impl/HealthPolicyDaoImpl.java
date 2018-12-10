package com.ims.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ims.dao.IHealthPolicyDao;
import com.ims.model.HealthPolicy;

@Repository
public class HealthPolicyDaoImpl implements IHealthPolicyDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveHealthPolicy(HealthPolicy healthPolicy) {
		return (Integer) hibernateTemplate.save(healthPolicy);
	}

	@Override
	public void deleteHealthPolicy(Integer id) {
		hibernateTemplate.delete(new HealthPolicy(id));
	}

	@Override
	public void updateHealthPolicy(HealthPolicy healthPolicy) {
		hibernateTemplate.update(healthPolicy);
	}

	@Override
	public HealthPolicy getOneHealthPolicy(Integer id) {
		return hibernateTemplate.get(HealthPolicy.class, id);
	}

	@Override
	public List<HealthPolicy> getAllHealthPolicies() {
		return hibernateTemplate.loadAll(HealthPolicy.class);
	}

}
