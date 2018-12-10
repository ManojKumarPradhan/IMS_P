package com.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.ILIfePolicyDao;
import com.ims.model.LIfePolicy;
import com.ims.service.ILIfePolicyService;

@Service
public class LIfePolicyServiceimpl implements ILIfePolicyService {

	@Autowired
	private ILIfePolicyDao dao;

	@Transactional
	public Integer saveLIfePolicy(LIfePolicy lIfePolicy) {
		return dao.saveLIfePolicy(lIfePolicy);
	}

	@Transactional
	public void deleteLIfePolicy(Integer id) {
		dao.deleteLIfePolicy(id);
	}

	@Transactional
	public void updateLIfePolicy(LIfePolicy lIfePolicy) {
		dao.updateLIfePolicy(lIfePolicy);
	}

	@Transactional(readOnly = true)
	public LIfePolicy getOneLIfePolicy(Integer id) {
		return dao.getOneLIfePolicy(id);
	}

	@Transactional(readOnly = true)
	public List<LIfePolicy> getAllLIfePolicys() {
		return dao.getAllLIfePolicys();
	}

}
