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

import com.ims.model.LIfePolicy;
import com.ims.service.ILIfePolicyService;

@Controller
@RequestMapping("/policy/life")
public class LIfePolicyController {

	@Autowired
	private ILIfePolicyService service;

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("lIfePolicy", new LIfePolicy());
		return "LIfePolicyRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveLIfePolicy(@ModelAttribute LIfePolicy lIfePolicy, ModelMap map) {
		String message = null;
		Integer id = null;
		try {
			id = service.saveLIfePolicy(lIfePolicy);
			message = "Life Insurance Policy Register with id " + id;
		} catch (Exception e) {
			message = "Life Insurance Policy not saved due to " + e.getMessage();
		}
		map.addAttribute("message", message);
		map.addAttribute("lIfePolicy", new LIfePolicy());
		return "LIfePolicyRegister";
	}

	@RequestMapping("/getAll")
	public String getAllLIfePolicys(ModelMap map) {
		List<LIfePolicy> lIfePolicies = null;
		try {
			lIfePolicies = service.getAllLIfePolicys();
		} catch (Exception e) {

		}
		map.addAttribute("lIfePolicies", lIfePolicies);
		return "LifePolicyData";
	}

	@RequestMapping("/delete")
	public String deleteLIfePolicy(@RequestParam Integer id, ModelMap map) {
		String message = null;
		List<LIfePolicy> lIfePolicies = null;
		try {
			service.deleteLIfePolicy(id);
			lIfePolicies = service.getAllLIfePolicys();
			message = "Life Insurance Policy deleted Sucessfully";
		} catch (HibernateOptimisticLockingFailureException e) {
			message = "Policy Not Found";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("lIfePolicies", lIfePolicies);
		map.addAttribute("message", message);
		return "LifePolicyData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam Integer id, ModelMap map) {
		LIfePolicy lIfePolicy = null;
		try {
			lIfePolicy = service.getOneLIfePolicy(id);
		} catch (Exception e) {

		}
		map.addAttribute("lIfePolicy", lIfePolicy);
		return "LifePolicyEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateLifePolicy(@ModelAttribute LIfePolicy lIfePolicy, ModelMap map) {
		String message = null;
		List<LIfePolicy> lIfePolicies = null;
		try {
			service.updateLIfePolicy(lIfePolicy);
			lIfePolicies = service.getAllLIfePolicys();
			message = "Life Insurance Policy updated Sucessfully";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("lIfePolicies", lIfePolicies);
		map.addAttribute("message", message);
		return "LifePolicyData";
	}
}
