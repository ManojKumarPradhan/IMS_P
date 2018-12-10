package com.ims.service;

import java.util.List;

import com.ims.model.MotorPolicy;

public interface IMotorPolicyService {

	public Integer saveMotorPolicy(MotorPolicy motorPolicy);

	public void deleteMotorPolicy(Integer id);

	public void updateMotorPolicy(MotorPolicy motorPolicy);

	public MotorPolicy getOneMotorPolicy(Integer id);

	public List<MotorPolicy> getAllMotorPolicies();
}
