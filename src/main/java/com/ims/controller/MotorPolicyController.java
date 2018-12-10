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

import com.ims.model.MotorPolicy;
import com.ims.service.IMotorPolicyService;

@Controller
@RequestMapping("/policy/motor")
public class MotorPolicyController {

	@Autowired
	private IMotorPolicyService service;

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("motorPolicy", new MotorPolicy());
		return "MotorPolicyRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMotorPolicy(@ModelAttribute MotorPolicy motorPolicy, ModelMap map) {
		String message = null;
		Integer id = null;
		try {
			id = service.saveMotorPolicy(motorPolicy);
			message = "Motor Insurance Policy Register with id " + id;
		} catch (Exception e) {
			message = "Motor Insurance Policy not saved due to " + e.getMessage();
		}
		map.addAttribute("message", message);
		map.addAttribute("motorPolicy", new MotorPolicy());
		return "MotorPolicyRegister";
	}

	@RequestMapping("/getAll")
	public String getAllMotorPolicies(ModelMap map) {
		List<MotorPolicy> motorPolicies = null;
		try {
			motorPolicies = service.getAllMotorPolicies();
		} catch (Exception e) {

		}
		map.addAttribute("motorPolicies", motorPolicies);
		return "MotorPolicyData";
	}

	@RequestMapping("/delete")
	public String deleteMotorPolicy(@RequestParam Integer id, ModelMap map) {
		String message = null;
		List<MotorPolicy> motorPolicies = null;
		try {
			service.deleteMotorPolicy(id);
			motorPolicies = service.getAllMotorPolicies();
			message = "Motor Insurance Policy deleted Sucessfully";
		} catch (HibernateOptimisticLockingFailureException e) {
			message = "Policy Not Found";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("motorPolicies", motorPolicies);
		map.addAttribute("message", message);
		return "MotorPolicyData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam Integer id, ModelMap map) {
		MotorPolicy motorPolicy = null;
		try {
			motorPolicy = service.getOneMotorPolicy(id);
		} catch (Exception e) {

		}
		map.addAttribute("motorPolicy", motorPolicy);
		return "MotorPolicyEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMotorPolicy(@ModelAttribute MotorPolicy motorPolicy, ModelMap map) {
		String message = null;
		List<MotorPolicy> motorPolicies = null;
		try {
			service.updateMotorPolicy(motorPolicy);
			motorPolicies = service.getAllMotorPolicies();
			message = "Motor Insurance Policy updated Sucessfully";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("motorPolicies", motorPolicies);
		map.addAttribute("message", message);
		return "MotorPolicyData";
	}
}
