package com.ims.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ims.dao.ILIfePolicyDao;
import com.ims.model.LIfePolicy;

@Repository
public class LIfePolicyDaoImpl implements ILIfePolicyDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveLIfePolicy(LIfePolicy lIfePolicy) {
		return (Integer) hibernateTemplate.save(lIfePolicy);
	}

	@Override
	public void deleteLIfePolicy(Integer id) {
		hibernateTemplate.delete(new LIfePolicy(id));
	}

	@Override
	public void updateLIfePolicy(LIfePolicy lIfePolicy) {
		hibernateTemplate.update(lIfePolicy);
	}

	@Override
	public LIfePolicy getOneLIfePolicy(Integer id) {
		return hibernateTemplate.get(LIfePolicy.class, id);
	}

	@Override
	public List<LIfePolicy> getAllLIfePolicys() {
		return hibernateTemplate.loadAll(LIfePolicy.class);
	}

}
