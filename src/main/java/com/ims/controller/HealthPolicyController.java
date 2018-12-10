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

import com.ims.model.HealthPolicy;
import com.ims.service.IHealthPolicyService;

@Controller
@RequestMapping("/policy/health")
public class HealthPolicyController {

	@Autowired
	private IHealthPolicyService service;

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("healthPolicy", new HealthPolicy());
		return "HealthPolicyRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHealthPolicy(@ModelAttribute HealthPolicy healthPolicy, ModelMap map) {
		String message = null;
		Integer id = null;
		try {
			id = service.saveHealthPolicy(healthPolicy);
			message = "Health Insurance Policy Register with id " + id;
		} catch (Exception e) {
			message = "Health Insurance Policy not saved due to " + e.getMessage();
		}
		map.addAttribute("message", message);
		map.addAttribute("healthPolicy", new HealthPolicy());
		return "HealthPolicyRegister";
	}

	@RequestMapping("/getAll")
	public String getAllHealthPolicys(ModelMap map) {
		List<HealthPolicy> healthPolicies = null;
		try {
			healthPolicies = service.getAllHealthPolicies();
		} catch (Exception e) {

		}
		map.addAttribute("healthPolicies", healthPolicies);
		return "HealthPolicyData";
	}

	@RequestMapping("/delete")
	public String deleteHealthPolicy(@RequestParam Integer id, ModelMap map) {
		String message = null;
		List<HealthPolicy> healthPolicies = null;
		try {
			service.deleteHealthPolicy(id);
			healthPolicies = service.getAllHealthPolicies();
			message = "Health Insurance Policy deleted Sucessfully";
		} catch (HibernateOptimisticLockingFailureException e) {
			message = "Policy Not Found";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("healthPolicies", healthPolicies);
		map.addAttribute("message", message);
		return "HealthPolicyData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam Integer id, ModelMap map) {
		HealthPolicy healthPolicy = null;
		try {
			healthPolicy = service.getOneHealthPolicy(id);
		} catch (Exception e) {

		}
		map.addAttribute("healthPolicy", healthPolicy);
		return "HealthPolicyEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateLifePolicy(@ModelAttribute HealthPolicy healthPolicy, ModelMap map) {
		String message = null;
		List<HealthPolicy> healthPolicies = null;
		try {
			service.updateHealthPolicy(healthPolicy);
			healthPolicies = service.getAllHealthPolicies();
			message = "Health Insurance Policy updated Sucessfully";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("healthPolicies", healthPolicies);
		map.addAttribute("message", message);
		return "HealthPolicyData";
	}
}
