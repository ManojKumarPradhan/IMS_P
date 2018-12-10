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

import com.ims.model.TravelPolicy;
import com.ims.service.ITravelPolicyService;

@Controller
@RequestMapping("/policy/travel")
public class TravelPolicyController {

	@Autowired
	private ITravelPolicyService service;

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("travelPolicy", new TravelPolicy());
		return "TravelPolicyRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTravelPolicy(@ModelAttribute TravelPolicy travelPolicy, ModelMap map) {
		String message = null;
		Integer id = null;
		try {
			id = service.saveTravelPolicy(travelPolicy);
			message = "Travel Insurance Policy Register with id " + id;
		} catch (Exception e) {
			message = "Travel Insurance Policy not saved due to " + e.getMessage();
		}
		map.addAttribute("message", message);
		map.addAttribute("travelPolicy", new TravelPolicy());
		return "TravelPolicyRegister";
	}

	@RequestMapping("/getAll")
	public String getAllTravelPolicies(ModelMap map) {
		List<TravelPolicy> travelPolicies = null;
		try {
			travelPolicies = service.getAllTravelPolicies();
		} catch (Exception e) {

		}
		map.addAttribute("travelPolicies", travelPolicies);
		return "TravelPolicyData";
	}

	@RequestMapping("/delete")
	public String deleteTravelPolicy(@RequestParam Integer id, ModelMap map) {
		String message = null;
		List<TravelPolicy> travelPolicies = null;
		try {
			service.deleteTravelPolicy(id);
			travelPolicies = service.getAllTravelPolicies();
			message = "Travel Insurance Policy deleted Sucessfully";
		} catch (HibernateOptimisticLockingFailureException e) {
			message = "Policy Not Found";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("travelPolicies", travelPolicies);
		map.addAttribute("message", message);
		return "TravelPolicyData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam Integer id, ModelMap map) {
		TravelPolicy travelPolicy = null;
		try {
			travelPolicy = service.getOneTravelPolicy(id);
		} catch (Exception e) {

		}
		map.addAttribute("travelPolicy", travelPolicy);
		return "TravelPolicyEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateTravelPolicy(@ModelAttribute TravelPolicy travelPolicy, ModelMap map) {
		String message = null;
		List<TravelPolicy> travelPolicies = null;
		try {
			service.updateTravelPolicy(travelPolicy);
			travelPolicies = service.getAllTravelPolicies();
			message = "Travel Insurance Policy updated Sucessfully";
		} catch (Exception e) {
			message = "Internal Error";
		}
		map.addAttribute("travelPolicies", travelPolicies);
		map.addAttribute("message", message);
		return "TravelPolicyData";
	}
}
