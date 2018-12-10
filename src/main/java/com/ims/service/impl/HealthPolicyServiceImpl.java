package com.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.IHealthPolicyDao;
import com.ims.model.HealthPolicy;
import com.ims.service.IHealthPolicyService;

@Service
public class HealthPolicyServiceImpl implements IHealthPolicyService {

	@Autowired
	private IHealthPolicyDao dao;

	@Transactional
	public Integer saveHealthPolicy(HealthPolicy healthPolicy) {
		return dao.saveHealthPolicy(healthPolicy);
	}

	@Transactional
	public void deleteHealthPolicy(Integer id) {
		dao.deleteHealthPolicy(id);
	}

	@Transactional
	public void updateHealthPolicy(HealthPolicy healthPolicy) {
		dao.updateHealthPolicy(healthPolicy);
	}

	@Transactional(readOnly = true)
	public HealthPolicy getOneHealthPolicy(Integer id) {
		return dao.getOneHealthPolicy(id);
	}

	@Transactional(readOnly = true)
	public List<HealthPolicy> getAllHealthPolicies() {
		return dao.getAllHealthPolicies();
	}

}
