package com.huawei.servicestage.sample.springcloud.smartproperty.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.huawei.servicestage.sample.springcloud.smartproperty.client.PropertyInfoClient;
import com.huawei.servicestage.sample.springcloud.smartproperty.client.PropertyLayoutClient;
import com.huawei.servicestage.sample.springcloud.smartproperty.dao.ResidenceDao;
import com.huawei.servicestage.sample.springcloud.smartproperty.model.Residence;

@Controller
public class WebController {

	@Autowired
	PropertyInfoClient propInfoClient;
	
	@Autowired
	PropertyLayoutClient propLayoutClient;
	
	@Autowired
	ResidenceDao residenceDao;
	
	@GetMapping ("/")
	public String getIndex(Model model) {
		
		return "index";
	}
	
	@GetMapping ("/home")
	public String getHome(Model model, HttpSession session) {
		
		if(session.getAttribute("auth") != null && (Boolean)session.getAttribute("auth")) {
			
			BasicJsonParser parser = new BasicJsonParser();
			
			Residence residence = residenceDao.findByUserName(session.getAttribute("userName").toString());
			
			String propInfo = propInfoClient.getPropertyInfo(residence.getPropertyId());
			
			if(residence != null && propInfo != null) {
				model.addAttribute("propInfo", parser.parseMap(propInfo));
			}
			
			String propLayout = propLayoutClient.getPropertyLayout(residence.getLayoutId());
			
			if(residence != null && propLayout != null) {
				model.addAttribute("propLayout", parser.parseMap(propLayout));
			}
			
			return "home";
		}else {
			return "redirect:/";
		}
	}
}
