package com.ims.service;

import java.util.List;

import com.ims.model.Customer;

public interface ICustomerService {

	public Integer saveCustomer(Customer customer);

	public void deleteCustomer(Integer id);

	public void updateCustomer(Customer customer);

	public Customer getOneCustomer(Integer id);

	public List<Customer> getAllCustomers();
}
