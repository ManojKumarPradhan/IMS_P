package com.ims.service;

import java.util.List;

import com.ims.model.HealthPolicy;

public interface IHealthPolicyService {

	public Integer saveHealthPolicy(HealthPolicy healthPolicy);

	public void deleteHealthPolicy(Integer id);

	public void updateHealthPolicy(HealthPolicy healthPolicy);

	public HealthPolicy getOneHealthPolicy(Integer id);

	public List<HealthPolicy> getAllHealthPolicies();
}
