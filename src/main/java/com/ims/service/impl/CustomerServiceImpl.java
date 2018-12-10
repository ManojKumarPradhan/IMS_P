package com.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.ICustomerDao;
import com.ims.model.Customer;
import com.ims.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Transactional
	public Integer saveCustomer(Customer customer) {
		return dao.saveCustomer(customer);
	}

	@Transactional
	public void deleteCustomer(Integer id) {
		dao.deleteCustomer(id);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		dao.updateCustomer(customer);
	}

	@Transactional(readOnly = true)
	public Customer getOneCustomer(Integer id) {
		return dao.getOneCustomer(id);
	}

	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

}
