package com.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ims.model.Customer;
import com.ims.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "CustomerRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute Customer customer, ModelMap map) {
		String message = null;
		Integer id = null;
		try {
			id = service.saveCustomer(customer);
			message = "Customer Register with id " + id;
		} catch (Exception e) {
			message = "Customer not saved due to " + e.getMessage();
		}
		map.addAttribute("message", message);
		map.addAttribute("customer", new Customer());
		return "CustomerRegister";
	}

	@RequestMapping("/getAll")
	public String getAllCustomers(ModelMap map) {
		List<Customer> customers = null;
		try {
			customers = service.getAllCustomers();
		} catch (Exception e) {

		}
		map.addAttribute("customers", customers);
		return "CustomerData";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam Integer id, ModelMap map) {
		String message = null;
		List<Customer> customers = null;
		try {
			service.deleteCustomer(id);
			customers = service.getAllCustomers();
			message = "Customer deleted Sucessfully";
		} catch (HibernateOptimisticLockingFailureException e) {
			message = "Policy Not Found";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("customers", customers);
		map.addAttribute("message", message);
		return "CustomerData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam Integer id, ModelMap map) {
		Customer customer = null;
		try {
			customer = service.getOneCustomer(id);
		} catch (Exception e) {

		}
		map.addAttribute("customer", customer);
		return "CustomerEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute Customer customer, ModelMap map) {
		String message = null;
		List<Customer> customers = null;
		try {
			service.updateCustomer(customer);
			customers = service.getAllCustomers();
			message = "Customer updated Sucessfully";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("customers", customers);
		map.addAttribute("message", message);
		return "CustomerData";
	}
}