package com.ims.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ims.dao.ICustomerDao;
import com.ims.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveCustomer(Customer customer) {
		return (Integer) hibernateTemplate.save(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		hibernateTemplate.delete(new Customer(id));
	}

	@Override
	public void updateCustomer(Customer customer) {
		hibernateTemplate.update(customer);
	}

	@Override
	public Customer getOneCustomer(Integer id) {
		return hibernateTemplate.get(Customer.class, id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return hibernateTemplate.loadAll(Customer.class);
	}

}
