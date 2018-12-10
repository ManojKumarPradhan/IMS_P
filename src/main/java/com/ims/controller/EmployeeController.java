package com.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ims.model.Employee;
import com.ims.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	private static final Logger log = Logger.getLogger(EmployeeController.class);

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		log.info("Enter into show Register method");
		map.addAttribute("employee", new Employee());
		log.info("Exit form show Regster method");
		return "EmployeeRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Employee employee, @RequestParam CommonsMultipartFile file, ModelMap map) {
		log.info("Enter into save method");
		Integer id = null;
		String message = null;
		try {
			if (file != null) {
				log.info("Checking file is empty or not");
				employee.setDocName(file.getOriginalFilename());
				employee.setDocument(file.getBytes());
				log.info("file added to employee");
			}
			id = service.saveEmployee(employee);
			message = "Employee Register with id " + id;
			log.debug(message);
		} catch (Exception e) {
			log.error("Not saved due to " + e.getMessage());
		}
		map.addAttribute("message", message);
		map.addAttribute("employee", new Employee());
		log.info("Message added to ModelMap");
		log.info("About to exit from save method");
		return "EmployeeRegister";
	}

	@RequestMapping("/getAll")
	public String getAllEmployees(ModelMap map) {
		log.info("Enter into getAll method");
		List<Employee> employees = null;
		try {
			employees = service.getAllEmployees();
			log.debug("Employee data fetched");
		} catch (Exception e) {
			log.error("data not fetched due to " + e.getMessage());
		}
		map.addAttribute("employees", employees);
		log.info("About to exit from getAll");
		return "EmployeeData";
	}

	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id, ModelMap map) {
		log.info("Enter into delete method");
		String message = null;
		List<Employee> employees = null;
		try {
			service.deleteEmployee(id);
			employees = service.getAllEmployees();
			message = id + " Employee Deleted ";
			log.debug(message);
		} catch (HibernateOptimisticLockingFailureException e) {
			message = "Employee Not Found";
			log.error("Employee Not Found due to " + e.getMessage());
		} catch (Exception e) {
			message = "Something Went Wrong";
			log.error("Problem occure" + e.getMessage());
		}
		map.addAttribute("message", message);
		map.addAttribute("employees", employees);
		log.info("About to exit form delte method");
		return "EmployeeData";
	}

	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id, ModelMap map) {
		log.info("Enter into edit page");
		Employee employee = null;
		try {
			log.info("getting the data");
			employee = service.getOneEmployee(id);
			log.debug("Employee data fetched for id " + id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		map.addAttribute("employee", employee);
		log.info("About to exit from show");
		return "EmployeeEdit";
	}

	@RequestMapping("/update")
	public String updateUom(@ModelAttribute Employee employee, @RequestParam CommonsMultipartFile file, ModelMap map) {
		log.info("Enter into updateUom method");
		String message = null;
		List<Employee> employees = null;
		log.info("Valid data inserted");
		try {
			if (file.getOriginalFilename() != null) {
				log.info("Checking file is empty or not");
				employee.setDocName(file.getOriginalFilename());
				employee.setDocument(file.getBytes());
				log.info("file added to employee");
			}
			service.updateEmployee(employee);
			employees = service.getAllEmployees();
			message = "Employee of ID '" + employee.getId() + "' Updated Sucessfully";
			log.debug(message);
		} catch (Exception e) {
			message = "Something went wrong";
			log.error(e.getMessage());
		}
		map.addAttribute("message", message);
		map.addAttribute("employees", employees);
		log.info("exit from updateUom method");
		return "EmployeeData";
	}
}