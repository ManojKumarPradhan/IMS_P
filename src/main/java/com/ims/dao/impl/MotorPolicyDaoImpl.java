package com.ims.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ims.dao.IMotorPolicyDao;
import com.ims.model.MotorPolicy;

@Repository
public class MotorPolicyDaoImpl implements IMotorPolicyDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Integer saveMotorPolicy(MotorPolicy motorPolicy) {
		return (Integer) hibernateTemplate.save(motorPolicy);
	}

	@Override
	public void deleteMotorPolicy(Integer id) {
		hibernateTemplate.delete(new MotorPolicy(id));
	}

	@Override
	public void updateMotorPolicy(MotorPolicy motorPolicy) {
		hibernateTemplate.update(motorPolicy);
	}

	@Override
	public MotorPolicy getOneMotorPolicy(Integer id) {
		return hibernateTemplate.get(MotorPolicy.class, id);
	}

	@Override
	public List<MotorPolicy> getAllMotorPolicies() {
		return hibernateTemplate.loadAll(MotorPolicy.class);
	}

}
