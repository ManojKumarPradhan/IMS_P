package com.ims.service;

import java.util.List;

import com.ims.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee employee);

	public void deleteEmployee(Integer id);

	public void updateEmployee(Employee employee);

	public Employee getOneEmployee(Integer id);

	public List<Employee> getAllEmployees();
}
