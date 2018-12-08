package com.ims.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
		log.info("");
		map.addAttribute("employee", new Employee());
		log.info("");
		return "EmployeeRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveData(@RequestParam CommonsMultipartFile file, @ModelAttribute Employee employee, ModelMap map) {
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
}