package com.ims.dao;

import java.util.List;

import com.ims.model.MotorPolicy;

public interface IMotorPolicyDao {

	public Integer saveMotorPolicy(MotorPolicy motorPolicy);

	public void deleteMotorPolicy(Integer id);

	public void updateMotorPolicy(MotorPolicy motorPolicy);

	public MotorPolicy getOneMotorPolicy(Integer id);

	public List<MotorPolicy> getAllMotorPolicies();
}
