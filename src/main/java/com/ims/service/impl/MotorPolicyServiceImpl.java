package com.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.IMotorPolicyDao;
import com.ims.model.MotorPolicy;
import com.ims.service.IMotorPolicyService;

@Service
public class MotorPolicyServiceImpl implements IMotorPolicyService {

	@Autowired
	private IMotorPolicyDao dao;

	@Transactional
	public Integer saveMotorPolicy(MotorPolicy motorPolicy) {
		return dao.saveMotorPolicy(motorPolicy);
	}

	@Transactional
	public void deleteMotorPolicy(Integer id) {
		dao.deleteMotorPolicy(id);
	}

	@Transactional
	public void updateMotorPolicy(MotorPolicy motorPolicy) {
		dao.updateMotorPolicy(motorPolicy);
	}

	@Transactional(readOnly = true)
	public MotorPolicy getOneMotorPolicy(Integer id) {
		return dao.getOneMotorPolicy(id);
	}

	@Transactional(readOnly = true)
	public List<MotorPolicy> getAllMotorPolicies() {
		return dao.getAllMotorPolicies();
	}

}
