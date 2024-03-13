package com.loginapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loginapplication.model.User;

@Controller
public class MainController {
	
	@RequestMapping("/")
    public String home() {
    	return "registration";
   }
	
//	@RequestMapping("/LoginController") 
//	public String login(User user) {
//		return "login";
//	}
}
