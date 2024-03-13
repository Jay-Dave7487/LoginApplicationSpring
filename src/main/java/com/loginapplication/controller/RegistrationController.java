package com.loginapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.loginapplication.model.User;
import com.loginapplication.service.UserService;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
//
@SuppressWarnings("unused")
@Controller
@RequestMapping
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/RegistrationController")
    public String registerUser(@ModelAttribute("RegistrationController") User user) {
    	System.out.println("I am called Controller...");
    	 System.out.println("First Name: " + user.getFirstName()); // Print the first name
    	 user.setRole("user");
        userService.saveUser(user);
        return "redirect:/login.jsp"; 
    }
}


// FOR Image....
//@Controller
//@MultipartConfig
//public class RegistrationController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/RegistrationController")
//    public String registerUser(@ModelAttribute User user,@RequestPart(value = "image") MultipartFile imageFile) throws IOException, ServletException {
//		
//    	if(!imageFile.isEmpty()) {
//    		try {
//			byte[] bytes = imageFile.getBytes();
//			System.out.println(bytes.toString());
//			user.setImage(bytes);
//			userService.saveUser(user);
//			return "redirect:/login.jsp";
//		
//		} catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("Error...");
//			return "redirect:/registration.jsp";
//		}
//		} else {
//			System.out.println("No Image found...");
//			return "redirect:/registration.jsp";
//		}
//    }
//}
