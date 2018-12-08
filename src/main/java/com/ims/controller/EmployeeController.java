package com.ims.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ims.model.Employee;
import com.ims.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	private static final Logger log = Logger.getLogger(EmployeeController.class);

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		log.info("");
		map.addAttribute("employee", new Employee());
		log.info("");
		return "EmployeeRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Employee employee, ModelMap map) {
		Integer id = null;
		String message = null;
		try {
			id = service.saveEmployee(employee);
			message = "Employee Register with id " + id;
		} catch (Exception e) {

		}
		map.addAttribute("message", message);
		map.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}
}