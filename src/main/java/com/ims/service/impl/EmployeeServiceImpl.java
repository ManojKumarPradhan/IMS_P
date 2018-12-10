package com.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ims.dao.IEmployeeDao;
import com.ims.model.Employee;
import com.ims.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;

	@Transactional
	public Integer saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}

	@Transactional
	public void deleteEmployee(Integer id) {
		dao.deleteEmployee(id);
	}

	@Transactional
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}

	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		return dao.getOneEmployee(id);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
