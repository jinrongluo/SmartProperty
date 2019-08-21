package com.huawei.servicestage.sample.springcloud.smartproperty.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@PostMapping(value="/signin")
	public ModelAndView signIn(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model, HttpSession session) {
		
		if(userName.equalsIgnoreCase("john") && password.equals("john123")
				|| userName.equalsIgnoreCase("may") && password.equals("may123")
				|| userName.equalsIgnoreCase("jack") && password.equals("jack123")) {
			
			session.setAttribute("userName", userName);
			session.setAttribute("auth", true);
			
			ModelAndView mv = new ModelAndView("redirect:/home");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("redirect:/");
			mv.addObject("error", "Invalid User Name or Password");

			return mv;
		}
	}
	
	@PostMapping(value="/signout")
	public String signOut(Model model, HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
}
