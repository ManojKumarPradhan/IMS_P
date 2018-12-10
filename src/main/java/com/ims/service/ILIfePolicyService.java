package com.ims.service;

import java.util.List;

import com.ims.model.LIfePolicy;

public interface ILIfePolicyService {

	public Integer saveLIfePolicy(LIfePolicy lIfePolicy);

	public void deleteLIfePolicy(Integer id);

	public void updateLIfePolicy(LIfePolicy lIfePolicy);

	public LIfePolicy getOneLIfePolicy(Integer id);

	public List<LIfePolicy> getAllLIfePolicys();
}
