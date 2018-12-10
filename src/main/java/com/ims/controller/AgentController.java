package com.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ims.model.Agent;

@Controller
@RequestMapping("/agent")
public class AgentController {

	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("agent", new Agent());
		return "AgentRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Agent agent, @RequestParam CommonsMultipartFile photo, ModelMap map) {

		System.out.println(agent.getName());
		System.out.println(agent.getAge());
		System.out.println(photo.getOriginalFilename());
		return "AgentRegister";
	}
}
