package com.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.dao.IEmployeeDao;
import com.ims.model.Employee;
import com.ims.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;

	@Override
	public Integer saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		dao.deleteEmployee(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return dao.getOneEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
