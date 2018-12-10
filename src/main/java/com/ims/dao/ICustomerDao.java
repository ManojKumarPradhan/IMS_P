package com.ims.dao;

import java.util.List;

import com.ims.model.Customer;

public interface ICustomerDao {

	public Integer saveCustomer(Customer customer);

	public void deleteCustomer(Integer id);

	public void updateCustomer(Customer customer);

	public Customer getOneCustomer(Integer id);

	public List<Customer> getAllCustomers();
}
