package com.ims.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ims.dao.IEmployeeDao;
import com.ims.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveEmployee(Employee employee) {
		return (Integer) hibernateTemplate.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		hibernateTemplate.delete(new Employee(id));
	}

	@Override
	public void updateEmployee(Employee employee) {
		hibernateTemplate.update(employee);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return hibernateTemplate.get(Employee.class, id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return hibernateTemplate.loadAll(Employee.class);
	}

}
